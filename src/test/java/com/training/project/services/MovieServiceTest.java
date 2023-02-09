package com.training.project.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.project.dto.MovieDTO;
import com.training.project.dto.MovieGenre;
import com.training.project.repositories.MovieRepository;
import com.training.project.repositories.entities.MovieEntity;

@SpringBootTest
public class MovieServiceTest {

	@Mock
	private MovieRepository movieRepository;
	
	@InjectMocks
	private MovieServices movieServices;
	
	@DisplayName("Junit test for get all Movie (positive) scenario")
	@Test
	public void givenMovieList_whenGetAllMovie_thenGetMovieList() {
		
		//given - precondition or setup
		MovieEntity movieEntity = new MovieEntity(MovieGenre.Action, "Pathaan", LocalTime.now(), "UA",
				LocalDate.now(), "Soldier movie", "url");
		
		MovieEntity movieEntity2 = new MovieEntity(MovieGenre.Romance, "Ved", LocalTime.now(), "UA",
				LocalDate.now(), "Love Story", "url");
		
		//give 
		BDDMockito.given(movieRepository.findAll()).willReturn(List.of(movieEntity, movieEntity2));
		
		//when
		List<MovieDTO> movies = movieServices.getMovie();
		
		//then
		Assertions.assertThat(movies).isNotNull();
		Assertions.assertThat(movies.size()).isEqualTo(2);
	}
	
	@DisplayName("Junit test for saving all Movie (positive) scenario")
	@Test
	public void giveMovieObject_whenSaved_thenNewSavedMovieObject() {
		
		MovieDTO movieDTO = new MovieDTO(MovieGenre.Action, "Pathaan", LocalTime.now(), "UA",
				LocalDate.now(), "Soldier movie", "url");
		
//		BDDMockito.given(movieRepository.save(movieDTO)).willReturn(movieDTO);
		
		//when 
		MovieDTO movie = movieServices.saveMovie(movieDTO);
		
		//assertion 
		Assertions.assertThat(movie).isNotNull();
	}
}
