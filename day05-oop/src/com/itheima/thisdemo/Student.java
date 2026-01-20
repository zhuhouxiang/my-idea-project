package com.itheima.thisdemo;

public class Student {
    String name;
    public void print(){
        // this是一个变量，用在方法中，用于拿到当前对象。
        // 哪个对象调用这个方法，this就拿到哪个对象。
        System.out.println(this);
        System.out.println(this.name);
    }
}
