package com.itheima;

public class ArrayDemo3 {
    public static void main(String[] args) {
        // 目标：完成数组求最值
        int[] arr = {10, 200, 30, 40, 50};
        int max = getMax(arr);
        int min = getMin(arr);
        System.out.println(max);
        System.out.println(min);
    }
    // 设计一个方法，求数组的最大值返回。
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    // 设计一个方法，求数组的最小值返回。
    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }



}
