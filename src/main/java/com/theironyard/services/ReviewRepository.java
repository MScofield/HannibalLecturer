package com.theironyard.services;

import com.theironyard.entities.Review;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by scofieldservices on 1/6/17.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
