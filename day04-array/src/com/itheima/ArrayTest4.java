package com.itheima;

public class ArrayTest4 {
    public static void main(String[] args) {
        // 目标：完成斗地主游戏的做牌和洗牌
        start();
    }
    public static void start() {
        // 1. 做牌：创建一个动态初始化的数组存储54张牌
        String[] poker = new String[54];
        // 2. 准备四种花色，还有点数，再开始做牌存入数组中去。
        String[] colors = {"♦", "♣", "♥", "♠"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        // 3. 遍历点数，再遍历花色
        int index = 0; // 记录当前牌在数组中的索引
        for (int i = 0; i < numbers.length; i++) {
            // 当前点数： numbers[i]
            for (int j = 0; j < colors.length; j++) {
                // 4. 将牌存入数组中
                poker[index] = colors[j] + numbers[i];
                index++;
            }
        }
        // 5. 存入大小王
        poker[index++] = "小王";
        poker[index] = "大王";
        System.out.println(poker.length);

        // 6. 打印牌
        System.out.println("新牌：");
        for (int i = 0; i < poker.length; i++) {
            System.out.print(poker[i] + " ");
        }
        System.out.println();// 换行

        // 7. 洗牌：把54张牌的数组poker中的牌顺序打乱
        // poker = [♦3 ♣3 ♥3 ♠3 ♦4 ♣4 ♥4 ♠4 ♦5 ♣5 ♥5 ♠5 ♦6 ♣6 ♥6 ♠6 ♦7 ♣7 ♥7 ♠7 ...]
        //           0  1  2  3  4  5  6  7  8  9  10  11 12 13 14 15 16 17 18 19
        for (int i = 0; i < poker.length; i++) {
            int index1 = (int)(Math.random() * poker.length);
            String temp = poker[i];
            poker[i] = poker[index1];
            poker[index1] = temp;
            System.out.print(poker[i] + " ");
        }

    }
}
