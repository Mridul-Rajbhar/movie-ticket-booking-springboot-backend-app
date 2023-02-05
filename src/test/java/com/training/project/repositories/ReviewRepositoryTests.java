package com.training.project.repositories;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.training.project.repositories.entities.ReviewsEntity;

@ActiveProfiles("test")
@DataJpaTest
public class ReviewRepositoryTests {
	@Autowired
	ReviewsRepository reviewsRepository;
	
	@Test
	public void post_review_star_with_value_3_not_comment() {
		//pre setup
		ReviewsEntity reviewsEntity = new ReviewsEntity(3,null);
		
		//action
		ReviewsEntity returnedReviewEntity = this.reviewsRepository.save(reviewsEntity);
		
		//verification
		assertThat(returnedReviewEntity).isNotNull();
		assertThat(returnedReviewEntity.getStars()).isEqualTo(3);
		assertThat(returnedReviewEntity.getComment()).isNull();
		
		
	}
}
