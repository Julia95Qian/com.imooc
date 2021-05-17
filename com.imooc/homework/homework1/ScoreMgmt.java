package imooc.homework1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScoreMgmt {
    public static void main(String[] args) {
        // 声明null数组
        float[] score = null;
        while (true) {
            ScoreMgmt sm = new ScoreMgmt();
            sm.displayMenu();
            Scanner sc = new Scanner(System.in);
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

            switch (choice) {
                case 1:
                    score = sm.initScore();
                    break;

                case 2:
                    if(score!=null){
                        float ave = sm.average(score);
                        System.out.println("数学平均成绩为：" + ave);
                    }else{
                        System.out.println("请先初始化成绩数组");
                        continue;
                    }
                    break;

                case 3:
                if(score!=null){
                        int goodNum = sm.count(score);
                        System.out.println("成绩大于85分的人数为：" + goodNum);
                    }else 
                    {
                        System.out.println("请先初始化成绩数组");
                    }
                    break;

                case 4:
                if(score!=null){
                    System.out.println("修改前：");
                    System.out.println("成绩为：");
                    for (int i = 0; i < score.length; i++) {
                        System.out.print(score[i] + "  ");
                    }
                    System.out.println();
                    System.out.println("请输入要修改数据的位置（从零开始）：");
                    int index = 0;
                    try {
                        index = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("输入的不是数字，请重新输入");
                        // 当接收数据异常，接收异常数据
                        sc.next();
                        // 重新执行本次循环
                        continue;
                    }
                    if (index < 0 || index >= score.length) {
                        System.out.println("输入的修改数据的位置有误，请重新输入0~" + (score.length-1) + "之间的数据");
                        break;
                    }
                    System.out.println("请输入新数据：");
                    float newScore = 0;
                    try {
                        newScore = sc.nextFloat();
                        ;
                    } catch (InputMismatchException e) {
                        System.out.println("输入的不是数字，请重新输入");
                        // 当接收数据异常，接收异常数据
                        sc.next();
                        // 重新执行本次循环
                        continue;
                    }

                    score = sm.update(score, index, newScore);
                    System.out.println("修改后：");
                    System.out.println("成绩为：");
                    for (int i = 0; i < score.length; i++) {
                        System.out.print(score[i] + "  ");
                    }
                    System.out.println();
                }else{System.out.println("请先初始化成绩数组");}
                    break;

                case 5:
                    if(score!=null){
                        sm.displayAllScore(score);          
                    }else{
                        System.out.println("请先初始化成绩数组"); 
                    }        
                    break;

                case 0:
                    System.exit(0);// JVM退出

                default:
                    System.out.println("输入的数字有误，请重新输入");
                    break;
            }
        }
    }

    // 显示菜单方法
    public void displayMenu() {
        System.out.println("**********************");
        System.out.println("    1--初始化数学成绩");
        System.out.println("    2--求成绩的平均值");
        System.out.println("    3--统计成绩大于85分的人数");
        System.out.println("    4--修改指定位置处的成绩");
        System.out.println("    5--打印输出所有成绩");
        System.out.println("    0--退出");
        System.out.println("**********************");
        System.out.println("请输入对应的数字进行操作：");
    }

    // 初始化数学成绩方法
    public float[] initScore() {
        System.out.println("请输入要存储的数学成绩的数量：");
        Scanner sc = new Scanner(System.in);
        // 在接收数组长度时，建议添加try-catch的异常处理，避免出现
        // InputMismatchException数字异常。
        int ScoreNum = 0;
        try {
            ScoreNum = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("输入的不是数字，请重新输入");
            return null;
        }
        float[] Score = new float[ScoreNum];
        for (int i = 0; i < ScoreNum; i++) {
            System.out.println("请输入第" + (i + 1) + "个数据：");
            try {
                Score[i] = sc.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("输入的不是数字，请重新输入");
                // 当接收数据异常，接收异常数据
                sc.next();
                // 重新执行本次循环
                i--;
            }
        }
        // 数组实例化完成之后将遍历输出
        for (float f : Score)
            System.out.println(f + " ");
        return Score;
    }

    // 求平均成绩方法
    public float average(float[] f) {
        float ave;
        float sum = 0;
        for (int i = 0; i < f.length; i++) {
            sum += f[i];
        }
        ave = sum / f.length;
        return ave;
    }

    // 统计成绩大于85分的人数的方法
    public int count(float[] f) {
        int num = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i] > 85) {
                num++;
            }
        }
        return num;
    }

    // 修改指定位置处的成绩的方法
    public float[] update(float[] f, int index, float newScore) {
        f[index] = newScore;
        return f;
    }

    // 打印输出所有成绩的方法
    public void displayAllScore(float[] f) {
        System.out.println("成绩为：");
        for (int i = 0; i < f.length; i++) {
            System.out.print(f[i] + "  ");
        }
        System.out.println();
    }

}