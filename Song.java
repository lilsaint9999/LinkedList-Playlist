package com.company;

public class Song {
    private String title;
    private Double duration;

    public Song(String name, Double duration) {
        this.title = name;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title + " : " + this.duration;
    }
}
