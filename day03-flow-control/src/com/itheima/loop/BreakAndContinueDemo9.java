package com.itheima.loop;

import java.util.Scanner;
public class BreakAndContinueDemo9 {
    public static void main(String[] args) {
        // 目标：理解break和continue的作用
        test1();
        test2();
        test3();
        calculator();

    }
    public static void test1() {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                break;

            }
            System.out.println("i = " + i);
        }
    }
    public static void test2() {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println("i = " + i);
        }
    }
    public static void test3() {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                return;
            }
            System.out.println("i = " + i);
        }
    }
    //目标: 设计一个可以执行基本数学运算(加、减、乘、除)的计算器程序。 功能描述: 用户输入两个数字、一个运算符(+、-、*、/)根据所选运算符执行相应的数学运算，显示运算结果。请告诉我实现步骤
    public static void calculator() {
        System.out.println("请输入两个数字：");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        System.out.println("请输入运算符：");
        char op = scanner.next().charAt(0);
        switch (op) {
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
                break;
            default:
                System.out.println("输入的运算符有误！");
        }
        scanner.close();
        System.out.println("程序结束！");
    }
}
