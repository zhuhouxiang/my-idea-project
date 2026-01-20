package com.leyun.variable;

public class VariableDemo2 {
    public static void main(String[] args) {
        // 目标：掌握8种基本数据类型定义变量
        show();
    }
    public static void show() {
        // 1. byte
        byte b = 127;
        System.out.println(b);
        // 2. short
        short s = 32767;
        System.out.println(s);
        // 3. int
        int i = 2147483647;
        System.out.println(i);
        // 4. long
        long l = 9223372036854775807L;
        System.out.println(l);
        // 5. float
        float f = 3.14f;
        System.out.println(f);
        // 6. double
        double d = 3.14;
        System.out.println(d);
    }
}
