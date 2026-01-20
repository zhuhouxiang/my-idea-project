package com.itheima;

import java.util.Scanner;

public class ArrayDemo2 {
    public static void main(String[] args) {
        // 目标: 掌握数组的另一种定义方式：动态初始化数组
        inputStudentScore();
    }
    // 设计一个方法录入学生成绩
    public static void inputStudentScore() {
        // 创建一个数组，用于存储8个学生的成绩
        // 动态初始化数组，只确定数组的类型和存储数据的容量。不事先存入具体的数据。
        // 数据类型[] 数组名 = new 数据类型[数组的长度];
        double[] scores = new double[8];
        for (int i = 0; i < scores.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个学生的成绩：");
            Scanner sc = new Scanner(System.in);
            scores[i] = sc.nextDouble();
        }
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        System.out.println("平均分：" + sum / scores.length);
    }
}
