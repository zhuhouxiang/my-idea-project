package com.itheima.branch;

public class ifTest2 {
    public static void main(String[] args) {
        // 目标：完成自动汽车驾驶程序的书写；以便可以根据红绿灯状态正确行驶
        drive();
    }
    public static void drive(){
        // 1. 假设现在通过摄像头获取到三种灯的状态信息如下
        boolean red = true;
        boolean yellow = false;
        boolean green = false;
        // 2. 根据状态信息，判断并输出
        if(red){
            System.out.println("红灯停");
        }else if(yellow){
            System.out.println("黄灯等");
        }else if(green){
            System.out.println("绿灯行");
        }else {
            System.out.println("请检查红绿灯状态");
        }
    }
}
