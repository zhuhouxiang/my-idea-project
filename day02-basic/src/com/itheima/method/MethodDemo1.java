package com.itheima.method;

public class MethodDemo1 {
    public static void main(String[] args) {
        // 目标：掌握方法的定义和使用
        int sum = getSum(10, 20);
        System.out.println("和是："+sum);
        System.out.println("----------------------------------------");
        int sum2 = getSum(100, 200);
        System.out.println("和是："+sum2);
        printHelloWorld();
        System.out.println("----------------------------------------");
        String code = getVerifyCode(4);
        System.out.println("验证码是："+code);
    }

    // 定义一个方法，求任意两个整数的和并返回
    public static int getSum(int a, int b) {
        return a + b;
    }

    // 需求：打印3行HelloWorld
    // 注意：如果方法没有返回结果，返回值类型必须声明成void.
    // 无参数，无返回值类型
    public static void printHelloWorld() {
        System.out.println("HelloWorld");
        System.out.println("HelloWorld");
        System.out.println("HelloWorld");
    }

    // 需求3：获取一个指定位数的验证码返回
    // 掌握方法的定义格式：
    // 需要接收数据吗？需要，需要接收位数。 int len
    // 需要返回数据吗？需要，返回验证码。 String
    // 有参数有返回值
    public static String getVerifyCode(int len) {
        String code = "";
        for (int i = 0; i < len; i++) {
            int number = (int)(Math.random()*10);
            code += number;
        }
        return code;
    }
}
