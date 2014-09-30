package com.stream;

import java.io.Serializable;

public class Data implements Serializable{

    private String name;
    private int score;

    public Data(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void print() {
        System.out.println(name + ": " + score);
    }


}
