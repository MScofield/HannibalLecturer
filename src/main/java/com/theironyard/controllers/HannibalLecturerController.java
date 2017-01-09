package com.theironyard.controllers;


import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import com.theironyard.services.LecturerRepository;
import com.theironyard.services.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Iterator;

/**
 * Created by scofieldservices on 1/6/17.
 */

@Controller
public class HannibalLecturerController {

        @Autowired
        LecturerRepository lecturers;

        @Autowired
        ReviewRepository reviews;

    @PostConstruct
    public void init(String[] args) throws SQLException {

    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Lecturer> flavaBeans () {
    return lecturers.findAll();
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Review> liver ()  {
    return reviews.findAll();
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.POST)
    public String basket (String name, String topic, String image) {
        Lecturer lecturer = new Lecturer(name, topic, image);
        lecturers.save(lecturer);
        return "index";
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public String lotion (String author, String text, int lecturerId, Boolean isGood) {
        Review review = new Review(author, text, lecturerId, isGood);
        reviews.save(review);
        return "index";
    }

}
