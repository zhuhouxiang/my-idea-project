package com.itheima.operator;

public class OperatorDemo5 {
    public static void main(String[] args) {
        print(10,2);
        print(10,2,3);
    }
    public static void print(int a, int b){
        int c = a > b ? a : b;
        System.out.println(c);
    }
    // 需求：求三个数的最大值
    public static void print(int a, int b, int c){
        int max = a > b ? a : b;
        max = max > c ? max : c;
        System.out.println(max);
    }
}
