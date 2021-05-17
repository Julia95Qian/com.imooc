package imooc.homework3;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CircusDemo {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            // 问这里的类对象定义是否也可以写在循环体外呢？
            CircusDemo cd = new CircusDemo();
            cd.displayMenu();  
            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("输入的不是数字，请重新输入");
                // 当接收数据异常，接收异常数据
                sc.next();
                // 重新执行本次循环
                continue;
            }
            switch(choice){
                case 1:
                    cd.show(new Bear("Bill", 1));
                    break;
                    
                case 2:
                    cd.show(new Lion("Lain", 2, "灰色","公"));
                    break;
    
                case 3:
                    cd.show(new Monkey("Tom", 1, "金丝猴"));
                    break;

                case 4:
                    cd.show(new Parrot("Rose", 1, "牡丹鹦鹉"));    
                    break;

                case 5:
                    cd.show(new Clown("Kohle", 5));    
                    break;

                default:
                    System.out.println("输入的数字有误，请重新输入");
                    break;
            }
            cd.continueWatch();
        }
    }
    // 显示菜单
    public void displayMenu(){
        System.out.println("**********欢迎来到太阳马戏团**********");
        System.out.println("**********请选择表演者**********");
        System.out.println("**********1. 棕熊**********");
        System.out.println("**********2. 狮子**********");
        System.out.println("**********3. 猴子**********");
        System.out.println("**********4. 鹦鹉**********");
        System.out.println("**********5. 小丑**********");
    }
    // 询问是否继续观看
    public void continueWatch(){
        while(true){
            System.out.println("**********是否继续观看（1/0）**********");
            Scanner sec_sc = new Scanner(System.in);
            int sec_choice;
            try {
                sec_choice = sec_sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("输入的不是数字，请重新输入");
                // 当接收数据异常，接收异常数据
                sec_sc.next();
                // 重新执行本次循环
                continue;
            }
            if(sec_choice==1){
                break;
            }
            else if(sec_choice==0){
                System.exit(0);// JVM退出
            }
            else{
                System.out.println("**输入信息不正确请重新输入**");
                // 重新执行本次循环
                continue;
            }
        }
    }
    // 展示动物技能
    public void show(IAct iAct){
        iAct.act();
    }
}
