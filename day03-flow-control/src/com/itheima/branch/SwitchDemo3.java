package com.itheima.branch;

public class SwitchDemo3 {
    public static void main(String[] args) {
        // 目标：搞清楚switch的使用,理解其执行流程
        recommendBook("男1");
    }
    // 需求：根据男女性别的不同，推荐不同的书本信息给其观看
    public static void recommendBook(String gender){
        switch (gender){
            case "男":
                System.out.println("推荐《java从入门到放弃》");
                break;
            case "女":
                System.out.println("推荐《java从入门到放弃》");
                break;
            default:
                System.out.println("推荐《java从入门到放弃？》");
        }
    }
}
