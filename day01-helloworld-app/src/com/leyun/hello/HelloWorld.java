package com.leyun.hello;

public class HelloWorld {
    public static void main(String[] args) {
        //System.out.println("Hello World");
        //System.out.println(getVerifyCode());
        printHelloWorld();
        System.out.println(getSum(1, 2));

        // 定义一个方法，帮我生成一个验证码返回
    }
    public static String getVerifyCode() {
        String code = "";
        for (int i = 0; i < 4; i++) {
            int number = (int)(Math.random() * 10);
            code += number;
        }
        return code;
    }
    //打印3行helloWorld
    public static void printHelloWorld() {
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
    }
    // 求两个任意整数的和
    public static int getSum(int a, int b) {
        return a + b;
    }

}
