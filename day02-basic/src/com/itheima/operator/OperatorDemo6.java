package com.itheima.operator;

public class OperatorDemo6 {
    public static void main(String[] args) {
        // 目标：掌握逻辑运算符的使用。
        System.out.println(check(180, 70, '女'));
        System.out.println(check(180, 90, '女'));
        System.out.println(check(180,300000));
        System.out.println(check(179,300000));

    }
    // 需求：判断某个人的条件是否满足择偶要求，如果满足返回true，否则返回false
    // 条件是：身高高于170，体重在60-80之间，且性别为女。
    public static boolean check(int height, int weight, char gender) {
        return height > 170 && weight >= 60 && weight <= 80 && gender == '女';
    }
    // 需求： 找一个男朋友，要么身高高于180，要么收入高于30万
    public static boolean check(int height, int income) {
        return height > 180 || income > 300000;
    }
}
