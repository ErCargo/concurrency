package com.ercargo.learn.concurrency.algrithm.bean;

/**
 * @author ercargo  on 2019/3/24
 * @DESCRIBE
 */
public class Teacher {
    private double salary;
    /**
     * 将User和Teacher 组合，而不是Teacher继承User
     */
    private User user;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName(){
       return user.getName();
    }
}
