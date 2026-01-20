package com.itheima.demo;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        // 目标: 设计一个可以执行基本数学运算(加、减、乘、除)的计算器程序。 功能描述: 用户输入两个数字、一个运算符(+、-、*、/)根据所选运算符执行相应的数学运算，显示运算结果。请告诉我实现步骤
        System.out.println("请输入两个数字：");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        System.out.println("请输入运算符：");
        String op = scanner.next();
        System.out.println(getResult(a, b, op));

    }
    // 把这个数据交给一个独立的计算方法，帮我计算结果并返回给我
    public static double getResult(double a, double b, String op) {
        double result = 0;
        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                System.out.println("输入的运算符有误！");
        }
        return result;
    }
}
