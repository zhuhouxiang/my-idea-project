package com.itheima.operator;

public class OperatorDemo3 {
    public static void main(String[] args) {
        // 目标：掌握扩展的赋值运算符
        receive(1000);
    }
    // 需求：收红包
    public static void receive(int money) {
        // 拿到自己钱包的金额
        int myMoney = 100;
        myMoney += money;// myMoney = myMoney + money;
        System.out.println("收红包成功，余额为：" + myMoney);

    }
}
