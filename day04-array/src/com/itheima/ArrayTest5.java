package com.itheima;

public class ArrayTest5 {
    public static void main(String[] args) {
        // 目标：二维数组的认识。
       // printArray();
        printArray2();
        printArray3();
    }
    public static void printArray() {
        // 初始化二维数组存储学生姓名，考虑到座位不规则，直接定义每排的座位
        // 静态初始化数组
        String[][] classroom = {
                {"张无忌","赵敏","周芷若"},
                {"张三丰","宋远桥","殷梨亭"},
                {"灭绝","陈昆","玄冥二老","金毛狮王"},
                {"杨道","纪晓芙"}
        };

        // 访问：数组名[行索引]
        String[] name = classroom[2];
        for(int i = 0; i < name.length; i++){
            System.out.println(name[i]);
        }
        // 访问2：数组名[行索引][列索引]
        System.out.println(classroom[1][1]);

        // 长度访问：数组名.length
        System.out.println(classroom.length);
        // 动态初始化数组
        int[][] arr =new int[3][5];

        // 遍历二维数组

    }
    public static void printArray2(){
        String[][] classroom = {
                {"张无忌","赵敏","周芷若"},
                {"张三丰","宋远桥","殷梨亭"},
                {"灭绝","陈昆","玄冥二老","金毛狮王"},
                {"杨逍","纪晓芙"}
        };
        for(int i =0;i<classroom.length;i++){
            String[] names = classroom[i];
            for(int j = 0;j<names.length;j++){
                System.out.print(names[j]+"\t");
            }
            System.out.println();
        }

    }
    public static void printArray3(){
        String[][] classroom = {
                {"张无忌","赵敏","周芷若"},
                {"张三丰","宋远桥","殷梨亭"},
                {"灭绝","陈昆","玄冥二老","金毛狮王"},
                {"杨逍","纪晓芙"}
        };
        for(int i = 0;i<classroom.length;i++){
            for(int j = 0;j<classroom[i].length;j++){
                int m = (int)(Math.random()*classroom.length);
                int n = (int)(Math.random()*classroom[m].length);
                String temp = classroom[m][n];
                classroom[m][n] = classroom[i][j];
                classroom[i][j]=temp;
            }

        }
        printArray4(classroom);
    }

    public static void printArray4(String[][] arr){
        for(int i =0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }

}
