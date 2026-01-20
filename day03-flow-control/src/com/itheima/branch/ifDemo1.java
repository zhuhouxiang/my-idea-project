package com.itheima.branch;

public class ifDemo1 {
    public static void main(String[] args) {
        // 目标：认识if语句，搞清楚其写法和应用场景
//        show();
//        show2();
        show3();
    }
    public static void show() {
        int age = 17;
        if (age >= 18) {
            System.out.println("可以投票");
        }
        System.out.println("程序结束");
    }
    public static void show2() {
        int age = 17;
        if (age >= 18) {
            System.out.println("可以投票");
        } else {
            System.out.println("不可以投票");
        }
        System.out.println("程序结束");
    }
    public static void show3() {
        int age = 18;
        if (age >= 18) {
            System.out.println("可以投票");
        } else if (age >= 16) {
            System.out.println("可以参与问卷调查");
        } else {
            System.out.println("不可以投票");
        }
        System.out.println("程序结束");
    }
}
