package com.theironyard.services;

import com.theironyard.entities.Lecturer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by scofieldservices on 1/6/17.
 */
public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {
}
