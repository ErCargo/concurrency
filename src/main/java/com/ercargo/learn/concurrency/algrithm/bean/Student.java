package com.ercargo.learn.concurrency.algrithm.bean;

/**
 * @author ercargo  on 2019/1/23
 * @DESCRIBE
 */
public class Student {
    private String name;
    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public Student() {
    }
}
