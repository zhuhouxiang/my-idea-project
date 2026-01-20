package com.itheima.loop;

public class ForForDemo8 {
    public static void main(String[] args) {
        // 目标：搞清楚循环嵌套的流程
        test1();
        print99();
    }
    public static void test1() {
        // 需求：打印4行5列星星
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // 定义一个方法，打印九九乘法表
    public static void print99() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }
}
