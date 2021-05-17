package com.imooc.jdbc.newsmgmt;

import com.imooc.jdbc.newsmgmt.command.*;

import java.sql.SQLException;
import java.util.Scanner;

public class NewsMgmt {
    public void mainMenuDisplay(){
        System.out.println("欢迎来到新闻管理系统");
        System.out.println("=====================");
        System.out.println("      1 添加新闻");
        System.out.println("      2 查看新闻");
        System.out.println("      3 编辑新闻");
        System.out.println("      4 删除新闻");
        System.out.println("      5 退出系统");
        System.out.println("请输入1-5之间的数字进行操作");
    }
    public void test(){
        // ???如何判断数据库里已存在表结构，若存在不重复创建，若不存在则创建
//        // 创建表结构
//        Command cmd = new StructureCommand();
//        cmd.execute();

        while(true){
            mainMenuDisplay();
            Scanner sc = new Scanner(System.in);
            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("请输入数字");
                continue;
            }
            Command ins = new InsertCommand();
            Command query = new QueryCommand();
            Command update = new UpdateCommand();
            Command delete = new DeleteCommand();

            switch (choice){
                case 1:
                    ins.execute();
                    query.execute();
                    break;
                case 2:
                    System.out.println("新闻列表如下");
                    query.execute();
                    break;
                case 3:
                    update.execute();
                    break;
                case 4:
                    query.execute();
                    delete.execute();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("输入错误，请重新输入1-5之间的数字");
                    continue;
            }

        }

    }
    public static void main(String[] args) {
        NewsMgmt nm = new NewsMgmt();
        nm.test();
    }
}
