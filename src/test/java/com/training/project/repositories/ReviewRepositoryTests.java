package com.training.project.repositories;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.training.project.dto.MovieGenre;
import com.training.project.repositories.entities.ContactAddressEntity;
import com.training.project.repositories.entities.MovieEntity;
import com.training.project.repositories.entities.ReviewsEntity;
import com.training.project.repositories.entities.UsersEntity;

@ActiveProfiles("test")
@DataJpaTest
public class ReviewRepositoryTests {
	@Autowired
	ReviewsRepository reviewsRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Test
	@DisplayName("JUNIT Test for save review stars not comments")
	public void givenReviewWithStarsNotComment_whenSave_thenReviewSavedWithOnlyStars() {
		//pre setup
		ReviewsEntity reviewsEntity = new ReviewsEntity(3,null);
		
		//action
		ReviewsEntity returnedReviewEntity = this.reviewsRepository.save(reviewsEntity);
		
		//verification
		assertThat(returnedReviewEntity).isNotNull();
		assertThat(returnedReviewEntity.getStars()).isEqualTo(3);
		assertThat(returnedReviewEntity.getComment()).isNull();	
	}
	
//-------------------------------------------------------------------------------------------
	
	@Test
	@DisplayName("JUNIT Test for save review comments not stars")
	public void givenReviewWithCommentsNotStars_whenSave_thenReviewSavedWithOnlyComment() {
		//pre setup
		ReviewsEntity reviewsEntity = new ReviewsEntity(null,"this is a good movie");
		
		//action
		ReviewsEntity returnedReviewEntity = this.reviewsRepository.save(reviewsEntity);
		
		//verification
		assertThat(returnedReviewEntity).isNotNull();
		assertThat(returnedReviewEntity.getComment()).isEqualTo("this is a good movie");
		assertThat(returnedReviewEntity.getStars()).isNull();	
	}
	
//-------------------------------------------------------------------------------------------

	
	@Test
	@DisplayName("JUNIT Test for save review")
	public void givenReview_whenSave_thenReviewSaved() {
		//pre setup
		ReviewsEntity reviewsEntity = new ReviewsEntity(3,"this is a good movie");
		
		//action
		ReviewsEntity returnedReviewEntity = this.reviewsRepository.save(reviewsEntity);
		
		//verification
		assertThat(returnedReviewEntity).isNotNull();
		assertThat(returnedReviewEntity.getComment()).isEqualTo("this is a good movie");
		assertThat(returnedReviewEntity.getStars()).isEqualTo(3);
	}
	
//-------------------------------------------------------------------------------------------

	
	@Test
	@DisplayName("JUNIT Test for finding review by user and movie")
	public void givenUserAndMovie_whenFindByUserAndMovie_thenGetReviewOfThatUserForThatMovie() {
		//setup
		ContactAddressEntity contactAddressEntity = new ContactAddressEntity("8928015475","mrodil@gmail.com");
		UsersEntity user = new  UsersEntity(contactAddressEntity,"Mridul","Rajbhar","Male",LocalDate.of(2023, 12, 21), "1231");
		MovieEntity movieEntity = new MovieEntity(MovieGenre.Action, "Pathaan", LocalTime.now(),"UA",LocalDate.of(2022, 2, 1),
				"desctription", "url");
		
		UsersEntity userSaved = this.usersRepository.save(user);
		MovieEntity movieSaved = this.movieRepository.save(movieEntity);
		
		ReviewsEntity reviewGiven = new ReviewsEntity(3,"Good Movie");
		reviewGiven.setUser(user);
		reviewGiven.setMovie(movieEntity);
		ReviewsEntity reviewSaved = this.reviewsRepository.save(reviewGiven);
		System.out.println(reviewSaved);
		
		//action
		ReviewsEntity reviewFound = this.reviewsRepository.findReviewByUserAndMovie(userSaved, movieSaved);
		
		
		//verification
		assertThat(reviewFound).isNotNull();
		assertThat(reviewFound).isEqualTo(reviewSaved);
	}
	
//---------------------------------------------------------------------------------------

	@Test
	@DisplayName("JUNIT Test for updating review")
	public void givenReview5StarsAndPositiveComment_whenUpdate_thenReview1StarAndNegativeComment() {
		//setup
		ContactAddressEntity contactAddressEntity = new ContactAddressEntity("8928015475","mrodil@gmail.com");
		UsersEntity user = new  UsersEntity(contactAddressEntity,"Mridul","Rajbhar","Male",LocalDate.of(2023, 12, 21), "1231");
		MovieEntity movieEntity = new MovieEntity(MovieGenre.Action, "Pathaan", LocalTime.now(),"UA",LocalDate.of(2022, 2, 1),
				"desctription", "url");
		
		UsersEntity userSaved = this.usersRepository.save(user);
		MovieEntity movieSaved = this.movieRepository.save(movieEntity);
		
		ReviewsEntity reviewGiven = new ReviewsEntity(5,"Good Movie");
		reviewGiven.setUser(userSaved);
		reviewGiven.setMovie(movieSaved);
		ReviewsEntity reviewSaved = this.reviewsRepository.save(reviewGiven);
		
		
		//action
		reviewSaved.setStars(1);
		reviewSaved.setComment("Bad");
		ReviewsEntity updatedReview = this.reviewsRepository.save(reviewSaved);
		
		//verification
		assertThat(updatedReview).isNotNull();
		assertThat(updatedReview.getStars()).isEqualTo(1);
		assertThat(updatedReview.getComment()).isEqualTo("Bad");
	}
	
//---------------------------------------------------------------------------------------


}
