package com.itheima.constructor;

public class Test {
    public  static void main(String[] args){
        // 目标：认识类的构造器，搞清楚其特点和常见应用场景
        // 构造器的特点： 创建对象时，对象会立即自动调用构造器。
        new Student();
        new Student("西门吹雪");

        System.out.println("==================");
        Student t1 =new Student();
        t1.name = "石头";
        t1.age = 22;
        t1.sex='男';
        System.out.println(t1.name);
        System.out.println(t1.age);
        System.out.println((t1.sex));

        //  对象的一种常见应用场景，创建对象时可以立即为对象赋值。
        Student t2 = new Student("猪猪",20,'男');
        System.out.println(t2.name);
        System.out.println(t2.age);
        System.out.println(t2.sex);
    }
}
