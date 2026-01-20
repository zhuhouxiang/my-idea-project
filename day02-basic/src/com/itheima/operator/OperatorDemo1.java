package com.itheima.operator;

public class OperatorDemo1 {
    public static void main(String[] args) {
        // 目标：理解运算符的使用
        print();
        print2();
    }
    public static void print() {
        int a = 10;
        int b = 20;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);
    }
    // 需求:研究+符号做连接符还是运算符.
    public static void print2() {
        String name = "张三";
        int age = 18;
        System.out.println("姓名："+name+"，年龄："+age);
        System.out.println(name+age);
        System.out.println(name+"年龄是："+age);
    }
}
