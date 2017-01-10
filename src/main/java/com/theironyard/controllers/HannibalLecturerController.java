package com.theironyard.controllers;


import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import com.theironyard.services.LecturerRepository;
import com.theironyard.services.ReviewRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public Iterable<Lecturer> getLecturers () {
    return lecturers.findAll();
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public Iterable<Review> getReviews ()  {
    return reviews.findAll();
    }

    @RequestMapping(path = "/create-lecturer", method = RequestMethod.POST)
    public void basket (String name, String topic, String image, HttpServletResponse response) {
        Lecturer lecturer = new Lecturer(name, topic, image);
        lecturers.save(lecturer);
    }

    @RequestMapping(path = "/create-review", method = RequestMethod.POST)
    public void lotion (String author, String text, Boolean isGood, Lecturer lecturer, HttpServletResponse response) {
        Review review = new Review(author, text, isGood, lecturer);
        reviews.save(review);
    }



}
