package com.itheima.demo;

public class Test4 {
    public static void main(String[] args) {
        // 判断101到200之间有多少个素数，并输出所有素数
        printPrime(101, 200);
    }
    public static boolean isPrime(int n) {
        for (int i = 2; i < n/2 ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void printPrime(int start, int end) {
       int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count++;
                System.out.println(i);
            }

        }
        System.out.println("素数的个数是：" + count);
    }
}
