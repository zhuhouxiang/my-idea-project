package com.itheima.operator;

public class OperatorDemo4 {
    public static void main(String[] args) {
        // 目标：理解关系运算符。
        print(10,2);

    }
    public static void print(int a, int b) {
         a = 10;
         b = 20;
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= b);
        System.out.println(a <= b);
        System.out.println(a == b);
        System.out.println(a != b);
    }
}
