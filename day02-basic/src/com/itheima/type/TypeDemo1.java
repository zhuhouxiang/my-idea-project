package com.itheima.type;

public class TypeDemo1 {
    public static void main(String[] args) {
        // 目标：认识自动类型转换，强制类型转换
        byte a = 12;
        print(a);   //自动类型转换
        print2(a);  // 自动类型转换

        System.out.println("=====================================");
        int i = 20;
        // print3(i);  // 类型范围大的变量不能直接赋值给类型范围小的变量，会报错的!!

        //强制类型转换。 类型 变量2 = （类型）变量1；
        byte j = (byte) i;
        print3(j);
    }
    public static void print(int b) {
        System.out.println(b);
    }
    public static void print2(double c) {
        System.out.println(c);
    }
    public static void print3(byte b) {
        System.out.println(b);
    }
}
