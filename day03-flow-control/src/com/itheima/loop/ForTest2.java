package com.itheima.loop;

public class ForTest2 {
    public static void main(String[] args) {
        // 目标：完成for循环求和的案例
        System.out.println(print());
    }
    public static int print(){
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
