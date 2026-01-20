package com.itheima.demo;

public class Test3 {
    public static void main(String[] args) {
       // 我是一个ava小白，现在有个需求是生产指定位数的验证码返回，每位只能是数字或者大写字母或者小写字母，请告诉我实现思路
        System.out.println(getCode(4));
    }
    public static String getCode(int n){
        String code = "";
        for (int i = 0; i < n; i++) {
            // 为当前位置随机生成一个数字或者大写字母或者小写字母
            int number = (int)(Math.random()*62);
            if (number < 10) {
                code += number;
                continue;
            }
            if (number < 36) {
                code += (char)(number + 'A' - 10);
                continue;
            }
            code += (char)(number + 'a' - 36);
        }
        return code;
    }


}
