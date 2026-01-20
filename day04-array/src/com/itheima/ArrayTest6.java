package com.itheima;

public class ArrayTest6 {
    public static void main(String[] args){
        // 目标：完成数字华容道的初始化和随机乱序
        start(4 ,5);
    }
    public static void start(int n,int n2){
        // 1. 定义一个二维数组存储数字列表
        int[][] arr = new int[n][n2];

        // 2. 遍历二维数组，给二维数组赋值。
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0;j<arr[i].length;j++){
                arr[i][j]=count++;
            }
        }
        printArray(arr);
        // 3. 打乱二维数组中的元素顺序。
        for(int i = 0;i< arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                // 遍历到的当前位置：arr[i][j]
                // 随机的索引位置处：m(随机的行) p(随机的列)
               int m = (int)(Math.random()* arr.length);
               int p = (int)(Math.random()* arr.length);

               // 定义一个临时变量存储m p 位置处的数据
               int temp = arr[m][p];
               // 把 i j 位置处的数据赋值给 m p
               arr[m][p] = arr[i][j];
               // 把 m p 位置处的数据temp记住的赋值给 i j
               arr[i][j] = temp;


            }

        }
        printArray(arr);
        
    }
    public static void printArray(int[][] arr){
        for(int i = 0; i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
