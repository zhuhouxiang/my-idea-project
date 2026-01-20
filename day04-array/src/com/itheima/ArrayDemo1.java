package com.itheima;

import java.util.Scanner;

public class ArrayDemo1 {
    public static void main(String[] args) {
        // 目标：认识使用数组的好处，数组的定义，访问。
        printRandomName();
        printStudentScore();
    }
    //开发一个随机点名的方法，随机点名15个同学
    public static void printRandomName() {
        // 静态初始化数组，定义数组的时候，数组已经确定好了
        String[] names = {"小王", "小李", "小张", "小赵", "小钱"};
        int index = (int)(Math.random() * names.length);
        System.out.println(names[index]);
    }
    // 假设班级有8名学生，该请帮我开发程序可以录入8名学生的Java成绩，成绩类型是小数，并输出平均分，最高分和最低分。
    public static void printStudentScore() {
        double[] scores = new double[8];
        for (int i = 0; i < scores.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个学生的Java成绩：");
            Scanner scanner = new Scanner(System.in);
            scores[i] = scanner.nextDouble();
        }
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        System.out.println("平均分：" + sum / scores.length);
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > scores[0]) {
                scores[0] = scores[i];
            }
        }
        System.out.println("最高分：" + scores[0]);
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < scores[0]) {
                scores[0] = scores[i];
            }
        }
        System.out.println("最低分：" + scores[0]);
    }
}
