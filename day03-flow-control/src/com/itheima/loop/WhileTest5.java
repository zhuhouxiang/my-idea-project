package com.itheima.loop;

public class WhileTest5 {
    public static void main(String[] args) {
        // 目标：理解while循环的写法，搞清楚其执行流程。
        test1();
        test2();
    }
    // 复利计算：我们本金10万，复利是1.7%，请问多少年后本金翻倍
    public static void test1() {
        int year = 0;
        double money = 100000;
        while (money < 200000) {
            year++;
            money = money * 1.017;
            System.out.println("第" + year + "年后，复利后的金额是：" + money);

        }
        System.out.println("需要" + year + "年后，本金翻倍");
    }
    // 需求：珠穆朗玛峰高度是8848860，纸张厚度是0.10mm，请用程序计算，折叠多少次可以到珠穆朗玛峰的高度。
    public static void test2() {
        int count = 0;
        double height = 0.10;
        while (height < 8848860) {
            count++;
            height = height * 2;
        }
        System.out.println("折叠了" + count + "次，可以到珠穆朗玛峰的高度");
    }
}
