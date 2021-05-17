package com.imooc.jdbc.goods;

import com.imooc.jdbc.goods.command.*;

import java.util.Scanner;

public class GoodsApplication {
    public static void main(String[] args) {
        System.out.println("请输入想要实现的功能");
        System.out.println("1--创建商品信息表goods");
        System.out.println("2--为商品信息表添加内容");
        System.out.println("3--查询价格在1500以上、3500以下的商品信息，并在控制台打印输出");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                // 建立表结构
                Command struct = new StructureCommand();
                struct.excute();
                break;
            case 2:
                // 添加表格信息
                Command insert = new InsertCommand();
                insert.excute();;
                break;
            case 3:
                // 查询信息
                Command query = new PstmtQueryCommand();
                query.excute();
                break;
        }
    }
}
