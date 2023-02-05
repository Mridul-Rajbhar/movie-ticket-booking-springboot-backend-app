package com.training.project.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.training.project.dto.MovieGenre;
import com.training.project.repositories.entities.CastEntity;
import com.training.project.repositories.entities.MovieEntity;


//to get in-memory datasource for unit testing
@ActiveProfiles("test")
@DataJpaTest
public class MovieRepositoryTests {

	@Autowired 
	private MovieRepository movieRepository;
	
	@Test
	public void givenMovieObject_whenSaved_thenNewMovieCreated() {
		//given-precondition order
		List<CastEntity> listCast=new ArrayList<>();
	 CastEntity cast1=new CastEntity("Allu Arjun","Actor");
	 MovieEntity movie1=new MovieEntity(MovieGenre.Action,"bahubali",LocalTime.now(),"A", LocalDate.now(), "this is bahubali movie","assets/Movies/images");	
	  movie1.setCast((List<CastEntity>)cast1);   
		//when-action or the behaviour we are testing
	  MovieEntity newCreatedMovie= movieRepository.save(movie1);
	  System.out.println("movie saved - " + newCreatedMovie);
		//then-verify the output
	  Assertions.assertThat(newCreatedMovie).isNotNull(); 
	}
	

	@Test
	@DisplayName("JUNIT test for getting Movie by Name operation")
	public void givenMovieObject_whenFindByName_thenReturnMovieObject()
	{
	// given - precondition or setup
		
     CastEntity cast1=new CastEntity("Allu Arjun","Actor");
		
	 MovieEntity movie1=new MovieEntity(MovieGenre.Action,"bahubali",LocalTime.now(),"A", LocalDate.now(), "this is bahubali movie","assets/Movies/images");	
//		  movie1.setCast((Set<CastEntity>) cast1);
     	  movieRepository.save(movie1);
////		// when - action or behavior that we are going to test
		MovieEntity movieReturned = movieRepository.findByMovieName(movie1.getMovieName()).get();
////		
////		// then - verify the output
		Assertions.assertThat(movieReturned).isNotNull();
		
}
	
//	@Test
//	@DisplayName("Junit test for deleting movie by name operation")
//	public void givenMovieObject_whenDeleteByName_thenDeleteMovieCountShouldReturn() {
//		 
//	 assertEquals(1, deletedMovieCount.intValue());
//	}

}





