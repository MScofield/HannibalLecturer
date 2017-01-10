package com.theironyard.entities;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

/**
 * Created by scofieldservices on 1/6/17.
 */

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue
    int id;

    @Column
    String author;

    @Column
    String text;

    @Column
    Boolean isGood;

    @ManyToOne
    Lecturer lecturer;

    public Review() {
    }

    public Review(String author, String text, Boolean isGood, Lecturer lecturer) {
        this.author = author;
        this.text = text;
        this.isGood = isGood;
        this.lecturer = lecturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getGood() {
        return isGood;
    }

    public void setGood(Boolean good) {
        isGood = good;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
}
