package com.example.ndpproblemstatement;

import java.io.Serializable;

public class Song implements Serializable {
    private int _id;
    private String title, singers;
    private int year, stars;

    public Song(int _id, String title, String singers, int year, int stars){
        this._id=_id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }
}
