package com.ercargo.learn.concurrency.algrithm.sort;


import com.ercargo.learn.concurrency.algrithm.bean.Student;

/**
 * @author ercargo  on 2019/1/23
 * @DESCRIBE
 */
public class BubbleSort2 {
    public static void main(String[] args) {

        int i;
        int j;


        Student[] students = new Student[6];
        students[0] = new Student("zhangsan", 80);
        students[1] = new Student("lisi", 100);
        students[2] = new Student("wangwu", 70);
        students[3] = new Student("zhaoliu", 60);
        students[4] = new Student("liyi", 30);
        students[5] = new Student("mm", 50);

        Student tmp = new Student();

        for (i = 1; i <= students.length - 1; i++) {
            for (j = 0; j < students.length - i; j++) {
                if (students[j].getScore() > students[j + 1].getScore()) {
                    tmp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = tmp;
                }
            }
        }

        for (i = 0; i <= students.length-1; i++) {
            System.out.println(students[i].getName());
        }

    }
}
