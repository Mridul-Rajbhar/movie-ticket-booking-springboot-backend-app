package com.training.project.services;

import static org.mockito.Mockito.times;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.training.project.dto.CastDto;
import com.training.project.dto.MovieDto;
import com.training.project.dto.MovieGenre;
import com.training.project.repositories.MovieRepository;
import com.training.project.repositories.entities.CastEntity;
import com.training.project.repositories.entities.MovieEntity;
import org.assertj.core.api.*;

@ExtendWith(MockitoExtension.class)
public class MovieServicesTest {

	@Mock
	private MovieRepository movieRepository;
	
	@InjectMocks
	private MovieService movieService;
	
	
@DisplayName("Junit test for get all movies scenario")
@Test
public void givenMovieList_whenGetAllMovies_thenGetMoviesList() {

	// given - precondition or setup
    List<CastEntity> listCast=new ArrayList<>();
    CastEntity cast1=new CastEntity("Allu Arjun","Actor");
    listCast.add(cast1);
    MovieEntity movie1=new MovieEntity(MovieGenre.Action,"bahubali",LocalTime.now(),"A", LocalDate.now(), "this is bahubali movie","assets/Movies/images/nbahubali.jpg");	
     movie1.setCast(listCast);  
  
     List<CastEntity> listCast2=new ArrayList<>();
     CastEntity cast2=new CastEntity("Ram charan","Actor");
     listCast.add(cast1);
     MovieEntity movie2=new MovieEntity(MovieGenre.Action,"Pushpa",LocalTime.now(),"A", LocalDate.now(), "this is bahubali movie","assets/Movies/images/nbahubali.jpg");	
      movie2.setCast(listCast);    
  
	// given
	BDDMockito.given(movieRepository.findAll()).willReturn(List.of(movie1 , movie2));

	// when
	List<MovieDto> movies = movieService.getAllMovies();

	// then
	//Assertions.assertThat(movies).isNotNull();
	Assertions.assertThat(movies.size()).isEqualTo(2);
	
}




































//	@DisplayName("Junit test for get all movies scenario")
//	@Test
//	public void givenMovieList_whenGetAllMovies_thenGetMoviesList() {
//	List<CastDto> listCast=new ArrayList<>();
//	CastDto cast1=new CastDto("Allu Arjun","Actor");
//	listCast.add(cast1);
//	MovieDto movie1=new MovieDto(MovieGenre.Action,"bahubali",LocalTime.now(),"A", LocalDate.now(), "this is bahubali movie","assets/Movies/images/nbahubali.jpg");	
//	 movie1.setCast(listCast);  
//	
//	 List<CastDto> listCast2=new ArrayList<>();
//	 CastDto cast2=new CastDto("Ram charan","Actor");
//	 listCast.add(cast1);
//	 MovieDto movie2=new MovieDto(MovieGenre.Action,"Pushpa",LocalTime.now(),"A", LocalDate.now(), "this is bahubali movie","assets/Movies/images/nbahubali.jpg");	
//	  movie2.setCast(listCast);    
//	
//	// given
//	BDDMockito.given(movieRepository.findAll()).willReturn(List.of(movie1 , movie2));
//	
//	// when
//	List<MovieDto> movies = movieService.getAllMovies();
//	
//	// then
//	Assertions.assertThat(movies).isNotNull();
//	Assertions.assertThat(movies.size()).isEqualTo(2);
//	}
//	
}









//
//	@DisplayName("Junit test for saving the movie object operation")
//	@Test
//	public void giveMovieObject_whenSaved_thenNewSavedMovieObject() {
//
//		// given
//		List<CastDto> listCast=new ArrayList<CastDto>();	
//		   CastDto cast1=new CastDto("Allu Arjun","Actor");
//		 listCast.add(cast1);
//		 MovieDto movie1=new MovieDto(MovieGenre.Action,"bahubali",LocalTime.now(),"A", LocalDate.now(), "this is bahubali movie","assets/Movies/images");	
//		  movie1.setCast(listCast);  
//		BDDMockito.given(movieRepository.save(movie1)).willReturn(movie1);
//		// when
//          MovieDto savedMovie = movieService.saveMovie(movie1);
//
//		// assertions
//		Assertions.assertThat(savedMovie).isNotNull();
//		Assertions.assertThat(savedMovie.getMovieName()).isEqualTo("bahubali");
//	}
//


	
//	@DisplayName("Junit test for delete movie operation")
//	@Test
//	public void givenOrderId_whenDleteOrder_thenNothing() {
//
//		// given
//		long id = 1L;
//
//		BDDMockito.willDoNothing().given(movieRepository).deleteByName(String movieName);
//
//		// when - action
//		movieService.deleteMovie(name);
//
//		// then - verify how many times deleteById is called
//		BDDMockito.verify(movieRepository, times(1)).deleteByNmae(name);
//	}
////	
//}
