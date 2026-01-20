package com.itheima.operator;

public class OperatorDemo2 {
    public static void main(String[] args) {
        // 目标：理解自增自检运算符的使用
        print(10);
        print2(10);
    }
    // 设计一个方法，接收一个整数
    public static void print(int a) {
        a++;
        ++a;
        System.out.println(a);
    }
    // 设计一个方法，理解自增和自减放在变量前后的区别
    public static void print2(int a) {
        System.out.println(a++);
        System.out.println(++a);
        System.out.println(a);
        System.out.println(--a);
        System.out.println(a--);
        System.out.println(a);

    }
}
