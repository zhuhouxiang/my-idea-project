package com.itheima.demo;

import java.util.Scanner;
public class Test2 {
    public static void main(String[] args) {
        // 随机生成一个1-100之间的数据，提示用户猜测，猜大提示过大，猜小提示过小，直到猜中结束游戏。请告诉我实现步骤
        test1();
    }
    public static void test1(){
        int number = (int)(Math.random()*100+1);
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入猜测的数字：");

            int guess = scanner.nextInt();
            if(guess > number){
                System.out.println("猜大了");
            }else if(guess < number){
                System.out.println("猜小了");
            }else{
                System.out.println("恭喜你猜对了");
                break;
            }
        }
    }
}
