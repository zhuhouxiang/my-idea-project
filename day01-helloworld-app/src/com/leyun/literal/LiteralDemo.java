package com.leyun.literal;
/**
 * 目标：掌握常见字面量的书写格式
 */
public class LiteralDemo {
    public static void main(String[] args) {
        printLiteral();
    }
    public static void printLiteral() {
    // 请帮我直接输出常见的字面量
        // 1.整型字面量，直接写
        System.out.println(1);
        // 2.浮点型字面量，直接写(小数)
        System.out.println(1.0);
        // 3.布尔型字面量，true/false
        System.out.println(true);
        // 4.字符型字面量，单引号里面有且只有一个字符
        System.out.println('a');
        // 5.字符串型字面量，双引号里面可以有多个字符
        System.out.println("hello");
        System.out.println("    world");
        // 掌握一些特殊字符: \
        System.out.println("hello\nworld");
        System.out.println("hello\tworld");
    }
}
