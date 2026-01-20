package com.itheima.loop;

public class WhileDemo4 {
    public static void main(String[] args) {
        // 目标：理解while循环的写法，搞清楚其执行流程。
        test1();
    }
    public static void test1() {
        int i = 1;
        while (i <= 5) {
            System.out.println("HelloWorld");
            i++;
        }
    }
}
