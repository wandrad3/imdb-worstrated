package com.overflix.infraestructure.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.overflix.entities.Image;
import com.overflix.entities.Movie;
import com.overflix.entities.UserReview;
import com.overflix.mappedIMDB.ApiImage;
import com.overflix.mappedIMDB.Movies;
import com.overflix.mappedIMDB.Review;
import com.overflix.mappedIMDB.Reviews;
import com.overflix.repositories.MovieRepository;
import com.overflix.services.ImageService;
import com.overflix.services.MovieService;
import com.overflix.services.ReviewService;

@Component
public class InsertDataForWebSite {

	@Autowired
	private MovieService movieService;
	@Autowired
	private ImageService imageService;

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private MovieRepository movieRepository;
	// tt0808240
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {

		String[] movieID = { "tt0362165", "tt0417056", "tt0317676", "tt0804492", "tt1316037", "tt4009460", "tt10888594",
				"tt0060666", "tt0799949", "tt1213644" };

		Optional<Movie> obj = Optional.of(movieService.getMovieByIdTitle("tt1213644"));

		int i=0;
		
		while(obj.isEmpty()) {
			System.out.println(obj.isEmpty());				
			insertMovie(movieID[i]);
			i++;
		}
		
		

	}

	public void insertMovie(String movieId) {
		System.out.println("MOVIEID" + movieId);
		Gson gson = new Gson();
		Movie movie = new Movie();
		//// O movies pode ser Transformado em Movie entity
		HttpHeaders headerMovie = new HttpHeaders();
		headerMovie.set("x-rapidapi-host", "movies-tvshows-data-imdb.p.rapidapi.com");
		headerMovie.set("x-rapidapi-key", "a27bec7244msh7c8ba957f876552p199655jsn1c3c7bd24d29");

		HttpEntity<String> entityMovie = new HttpEntity<>(headerMovie);
		ResponseEntity<Movies> movies = getMovies(
				"https://movies-tvshows-data-imdb.p.rapidapi.com/?type=get-movie-details&imdb=" + movieId, entityMovie);

		movie.setIdTitle(movies.getBody().getImdbID());
		movie.setName(movies.getBody().getTitle());
		movie.setFullName(movies.getBody().getTitle());
		movie.setDirectors(Stream.of(movies.getBody().getDirectors()).collect(Collectors.joining(" - ")));
		movie.setMainCast(Stream.of(movies.getBody().getStars()).collect(Collectors.joining(" - ")).substring(0, 254));

		HttpHeaders headerReview = new HttpHeaders();
		headerReview.set("x-rapidapi-host", "imdb8.p.rapidapi.com");
		headerReview.set("x-rapidapi-key", "a27bec7244msh7c8ba957f876552p199655jsn1c3c7bd24d29");

		// itemReviews.get(1).getAuthorRating()
		HttpEntity<String> entityReview = new HttpEntity<>(headerReview);
		ResponseEntity<Reviews> getReview = getReviews(
				"https://imdb8.p.rapidapi.com/title/get-user-reviews?tconst=" + movieId, entityReview);

		String jsonReview = gson.toJson(getReview.getBody().getReviews());
		TypeToken tt = new TypeToken<List<Review>>() {
		};
		List<Review> itemReviews = gson.fromJson(jsonReview, tt.getType());
		List<UserReview> userReviewList = new ArrayList<>();

		for (int i = 0; i < itemReviews.size(); i++) {

			if (Double.valueOf(itemReviews.get(i).getAuthorRating()) >= 5) {
				UserReview userReview = new UserReview();
				userReview.setIdTitle(movies.getBody().getImdbID());
				userReview.setTitle(movies.getBody().getTitle());
				userReview.setRate(BigDecimal.valueOf(Double.valueOf(itemReviews.get(i).getAuthorRating())));
				userReview.setUsername(itemReviews.get(i).getAuthor().getDisplayName());
				userReview.setContent(itemReviews.get(i).getReviewText().substring(0, 249));

				userReviewList.add(userReview);
				reviewService.insert(userReview);
				userReview.setIdTitle("");
				userReview.setTitle("");
				userReview.setRate(null);
				userReview.setUsername("");
				userReview.setContent("");

			}

		}

		movie.setReviews(userReviewList);

		userReviewList.clear();

		// O ImageElement pode se transformar em Image das Entities
		HttpHeaders headerImages = new HttpHeaders();
		headerImages.set("x-rapidapi-host", "movies-tvshows-data-imdb.p.rapidapi.com");
		headerImages.set("x-rapidapi-key", "a27bec7244msh7c8ba957f876552p199655jsn1c3c7bd24d29");

		HttpEntity<String> entityImage = new HttpEntity<>(headerImages);
		ResponseEntity<ApiImage> images = getImages(
				"https://movies-tvshows-data-imdb.p.rapidapi.com/?type=get-movies-images-by-imdb&imdb=" + movieId,
				entityImage);

		String jsonImages = gson.toJson(images.getBody());
		TypeToken ttImage = new TypeToken<ApiImage>() {
		};
		ApiImage imageElement = gson.fromJson(jsonImages, ttImage.getType());

		// imageElement.get(1);

		// List<Image> imageList = new ArrayList<>();

		Image image = new Image();
		image.setIdTitle(movies.getBody().getImdbID());
		image.setFanArt(imageElement.getFanart());
		image.setPoster(imageElement.getPoster());

		Image imageSaved = imageService.insert(image);

		movie.setImage(imageSaved);

		movie.setYear(movies.getBody().getYear());
		movie.setRate(BigDecimal.valueOf(Double.valueOf(movies.getBody().getImdbRating())));

		movieService.insertMovie(movie);

	}

	private ResponseEntity<ApiImage> getImages(String uri, HttpEntity<String> entityImage) {
		RestTemplate template = new RestTemplate();
		ResponseEntity<ApiImage> response = template.exchange(uri, HttpMethod.GET, entityImage, ApiImage.class);
		return response;
	}

	private ResponseEntity<Movies> getMovies(String uri, HttpEntity<String> entityMovie) {
		RestTemplate template = new RestTemplate();
		ResponseEntity<Movies> response = template.exchange(uri, HttpMethod.GET, entityMovie, Movies.class);
		return response;
	}

	private ResponseEntity<Reviews> getReviews(String uri, HttpEntity<String> entity) {
		RestTemplate template = new RestTemplate();
		ResponseEntity<Reviews> response = template.exchange(uri, HttpMethod.GET, entity, Reviews.class);
		return response;
	}
}
