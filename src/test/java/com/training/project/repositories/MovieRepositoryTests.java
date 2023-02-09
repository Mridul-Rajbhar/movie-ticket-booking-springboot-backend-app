package com.training.project.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.training.project.dto.MovieGenre;
import com.training.project.repositories.entities.CastEntity;
import com.training.project.repositories.entities.MovieEntity;

@DataJpaTest
@ActiveProfiles("test")
public class MovieRepositoryTests {

	@Autowired
	private MovieRepository movieRepository;
	
	
	@DisplayName("JUNIT Test for save movie operation")
	@Test
	public void giveMovieObject_whenSave_thenReturnSaveMovie() {

		List<CastEntity> cast = new ArrayList<CastEntity>();
		cast.add( new CastEntity("ritesh", "actor"));
		
		// Given
		MovieEntity movieEntity = new MovieEntity(MovieGenre.Action, "Pathaan", LocalTime.now(), "UA",
				LocalDate.now(), "Soldier movie", "url");
//		movieEntity.setCast(cast);
		
		//when
		MovieEntity newSavedMovie = movieRepository.save(movieEntity);
		
		//then
		assertThat(newSavedMovie).isNotNull();
		
	}
	
	@Test
	@DisplayName("JUNIT Test to  get all Movie operation")
	public void givenMovieList_whenFindAll_thenReturnMovieList() {
		
		List<CastEntity> cast = new ArrayList<CastEntity>();
		cast.add( new CastEntity("ritesh", "actor"));
		
		// Given
		MovieEntity movieEntity = new MovieEntity(MovieGenre.Action, "Pathaan", LocalTime.now(), "UA",
				LocalDate.now(), "Soldier movie", "url");
		
		MovieEntity movieEntity2 = new MovieEntity(MovieGenre.Romance, "Ved", LocalTime.now(), "UA",
				LocalDate.now(), "Love Story", "url");
		
		movieRepository.save(movieEntity);
		movieRepository.save(movieEntity2);
		
		//when 
		List<MovieEntity> movieList = movieRepository.findAll();
		
		System.out.println("movie List : " + movieList);
		
		//then 
		assertThat(movieList).isNotNull();
		
	}
	
	@Test
	@DisplayName("JUNIT Test to  get MovieByName operation")
	public void givenMovieName_whenFindByMovieName_thenReturnMovie() {
		
		// Given 
		MovieEntity movieEntity = new MovieEntity(MovieGenre.Romance, "Ved", LocalTime.now(), "UA",
				LocalDate.now(), "Love Story", "url");
		
		 
		movieRepository.save(movieEntity);
		
		// When 
		MovieEntity movie = movieRepository.getByMovieName("Ved");
		
		//then 
		assertThat(movie).isNotNull();
	}
}
	