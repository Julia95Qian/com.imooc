package com.imooc.jdbc.hrapp;

import com.imooc.jdbc.hrapp.command.*;

import java.util.Scanner;

public class HumanResourceApplication {
    public static void main(String[] args) {
        System.out.println("1-查询部门员工");
        System.out.println("2-新员工入职");
        System.out.println("3-调整员工工资");
        System.out.println("4-员工离职");
        System.out.println("5-分页查询员工数据");
        System.out.println("请选择功能：");
        Scanner in = new Scanner(System.in);
        Command command = null;
        switch (in.nextInt()) {
            case 1:// 查询部门员工
                command = new PstmtQueryCommand();
                command.execute();
                break;
            case 2:// 新增员工
                command = new InsertCommand();
                command.execute();
                break;

            case 3:// 调整工资
                command = new UpdateCommand();
                command.execute();
                break;
            case 4: // 删除员工
                command = new DeleteCommand();
                command.execute();
                break;
            case 5: // 分页查询
                command = new PaginationCommand();
                command.execute();
                break;
        }
    }
}
