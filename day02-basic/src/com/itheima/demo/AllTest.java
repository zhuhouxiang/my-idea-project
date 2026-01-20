package com.itheima.demo;

import java.util.Scanner;

public class AllTest {
    public static void main(String[] args) {
        // 目标：完成健康计算器。
        Scanner sc = new Scanner(System.in);
        // 1. 先让用户输入自己的个人信息：身高，体重，性别，年龄
        System.out.println("请输入你的身高：");
        double height = sc.nextDouble();
        System.out.println("请输入你的体重：");
        double weight = sc.nextDouble();
        System.out.println("请输入你的性别：");
        String sex = sc.next();
        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();
        double bmi = getBMI(height, weight);
        System.out.println("BMI指数："+bmi);
        double bmr = getBMR(height, weight, age, sex);
        System.out.println("BMR指数："+bmr);

        // 2. 根据个人信息，计算BMI指数
    }
    public static double getBMI(double height, double weight) {
        return weight / (height * height);
    }

    // 3. 根据个人信息，计算BMR指数
    public static double getBMR(double height, double weight, int age, String sex) {
        if ("男".equals(sex)) {
            return 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
        } else {
            return 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
        }
    }
}
