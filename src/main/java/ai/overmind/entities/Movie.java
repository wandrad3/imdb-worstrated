package ai.overmind.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@Entity
public class Movie implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String idTitle;

	private String name;

	private String fullName;

	private String directors;

	private String mainCast;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<UserReview> reviews;
	
	@OneToOne(fetch = FetchType.LAZY )
	private Image image;
	
	
	private BigDecimal rate;

	private String year;
	

}
