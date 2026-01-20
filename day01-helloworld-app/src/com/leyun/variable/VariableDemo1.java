package com.leyun.variable;

public class VariableDemo1 {
    public static void main(String[] args) {
        //  目标：认识变量
        show();
    }
    // 定义一个方法，来学习变量的定义
    public static void show() {
        // 定义变量:  数据类型 变量名称 = 初始值；
        int a = 10;
        System.out.println(a);

        // 定义一个小数变量，存储一个学生的Java成绩
        double score = 89.5;
        System.out.println(score);
        System.out.println("==============================");
        // 为什么要用变量记住数据呢？
        int number = 18;
        System.out.println(number);
        System.out.println(number);
        System.out.println(number);
        System.out.println(number);
        System.out.println(number);

        System.out.println("==============================");

        // 研究变量的特点，变量里的数据都是可以被替换的
        int age2=18;
        age2=19;
        System.out.println(age2);

        System.out.println("==============================");
        // 需求：微信钱包目前有9.9，发出去5元，又收到了6元，请实时输出钱包金额。
        double money = 9.9;
        System.out.println(money);
        // 发出去了5元
        money = money - 5;  // 赋值 （从右边往左边看）
        System.out.println(money);
        // 收到了6元
        money = money + 6;
        System.out.println(money);

        char ch = 'A';  // 65的二进制
        System.out.println(ch+1); // 66

        char ch2 = 'a'; // 97的二进制
        System.out.println(ch2+1);// 98
    }
}
