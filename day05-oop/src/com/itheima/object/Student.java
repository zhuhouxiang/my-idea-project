package com.itheima.object;

public class Student {
    String name;
    double yuwen;
    double shuxue;

    public void printAllScore(){
        System.out.println(name+"的总成绩是："+(yuwen+shuxue));
    }

    public void printAverageScore(){
        System.out.println(name+"的平均成绩是："+(yuwen+shuxue)/2);
    }
}


