package ai.overmind.infraestructure.web.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ai.overmind.entities.Image;
import ai.overmind.entities.Movie;
import ai.overmind.entities.UserReview;
import ai.overmind.services.ImageService;
import ai.overmind.services.MovieService;
import ai.overmind.services.ReviewService;

@Controller
@RequestMapping("/overflix")
public class MovieController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ReviewService reviewService;

	@GetMapping("/home")
	public String home(Model model) {

		List<Image> imgList  = imageService.getAllImages();

		model.addAttribute("lista", imgList);

		return "overflix-home";

	}
	@GetMapping("/info/{id}")
	public String movieInfo(@PathVariable("id") String id, Model model) {
		System.out.println("THE MOVIE" + id);
		Movie movie = new Movie();
		UserReview userReview = new UserReview();
		Image image = new Image();
		
		movie = movieService.getMovieByIdTitle(id);
		image = imageService.getImageByIdTitle(id);
		
		List<UserReview> userReviewList = reviewService.getReviewByIdTitle(id);
		if(userReviewList.size()==0) {
			userReview.setContent("There's no user review for this movie");
			userReview.setRate(BigDecimal.valueOf(0.0));
			userReview.setUsername("U");
			
		}else {
			userReview = userReviewList.get(0);

		}
		
		
		model.addAttribute("userReview", userReview);
		model.addAttribute("image", image);
		model.addAttribute("movie", movie);
		
		return "movie-info";

	}

}
