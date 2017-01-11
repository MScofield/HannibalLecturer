package com.theironyard.controllers;


import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import com.theironyard.services.LecturerRepository;
import com.theironyard.services.ReviewRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Iterator;

/**
 * Created by scofieldservices on 1/6/17.
 */

@RestController
public class HannibalLecturerController {

        @Autowired
        LecturerRepository lecturers;

        @Autowired
        ReviewRepository reviews;

        Server uidb = null;

    @PostConstruct
    public void init() throws SQLException {
        uidb = Server.createWebServer().start();

    }

    @PreDestroy
    public void destroy(){
        uidb.stop();
    }

//    managing and displaying lecturer data

//    returning a json of lecturers to the page
    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public Iterable<Lecturer> getLecturers () {return lecturers.findAll();}

//    saving a new lecturer to the database
    @RequestMapping(path = "/lecturers", method = RequestMethod.POST)
    public void createLecturer (String name, String topic, String image, HttpServletResponse response) {
        System.out.println(name);
        System.out.println(topic);
        System.out.println(image);
        System.out.println(response);
        Lecturer lecturer = new Lecturer(name, topic, image);
        System.out.println(lecturer);
        lecturers.save(lecturer);
    }


//    managing and displaying review data

//    returning a json of reviews to the page
    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public Iterable<Review> getReviews (int lecturerId)  {
        Lecturer lecturer = lecturers.findOne(lecturerId);
        return reviews.findByLecturer(lecturer);
    }

//    saving a new review to the database
    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void createReview (String author, String text, Boolean isGood, int lecturerId, HttpServletResponse response) {
        System.out.println(author);
        System.out.println(text);
        System.out.println(isGood);
        System.out.println(lecturerId);
        System.out.println(response);
        Lecturer lecturer = lecturers.findOne(lecturerId);
        System.out.println(lecturer);
        Review review = new Review(author, text, isGood, lecturer);
        System.out.println(review);
        reviews.save(review);
    }



}
