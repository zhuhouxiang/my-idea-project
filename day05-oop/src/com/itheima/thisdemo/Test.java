package com.itheima.thisdemo;

public class Test {
    public static void main(String[] args){
        // 目标：认识this关键字，搞清楚this关键字的应用场景
        Student s1 = new Student();
        s1.name="张三";
        s1.print();
        System.out.println(s1);

        System.out.println("======================");

        Student s2 = new Student();
        s2.print();
        System.out.println(s2);
    }
}
