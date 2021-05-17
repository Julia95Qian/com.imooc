import java.util.Scanner;


public class TestDemo {

    public void testClass() {
        // 测试添加学生
        Student stu1 = new Student("s001", "s", 87f, 78f);
        Student stu2 = new Student("s002", "ss", 88f, 70f);
        Class c1 = new Class("c001", "banji1");
        c1.addStudent(stu1);
        c1.addStudent(stu2);
        System.out.println("删除前：");
        c1.displayAllStudent();
        // 测试查询学生
        Student stu_s = c1.searchStudentByNum("s001");
        System.out.println("查询的学生信息：" + stu_s);
        // 输入语文成绩,数学成绩
        c1.insertChineseScore("s001", 88f);
        c1.insertMathScore("s001", 60f);
        System.out.println("s001的语文成绩：" + stu1.getChinese() + "数学成绩：" + stu1.getMath());
        // 删除学生信息
        c1.deleteStudent("s002");
        System.out.println("删除后：");
        c1.displayAllStudent();
    }

    public void testSchool() {
        School school = new School();
        Class c1 = new Class("c001", "一班");
        Class c2 = new Class("c002", "二班");
        // // 测试添加
        // school.addClass(c1);
        // school.addClass(c2);
        // System.out.println("删除前：");
        // school.displayClassName();
        // //测试查询
        // Class c3 = school.searchClassByName("一班");
        // if(c3==null){
        // System.out.println("没有这个班级信息");
        // }else{
        // System.out.println("一班信息为："+c3.getClassId());
        // }
        // // 测试删除
        // school.deleteClass(c1);
        // System.out.println("删除后：");
        // school.displayClassName();
        // 测试语文成绩排序
        Student stu1 = new Student("s001", "st1", 50, 60);
        Student stu2 = new Student("s002", "st2", 60, 50);
        Student stu3 = new Student("s003", "st3", 50, 80);
        c1.addStudent(stu1);
        c1.addStudent(stu2);
        c2.addStudent(stu3);
        school.addClass(c1);
        school.addClass(c2);
        school.sortChineseByAverage();
    }

    // 主菜单
    public void mainMenu() {
        System.out.println("**********************");
        System.out.println("      **主菜单**      ");
        System.out.println("      1--班级管理      ");
        System.out.println("      2--学校管理      ");
        System.out.println("      0--退出      ");
        System.out.println("**********************");
    }

    // 学校管理菜单
    public void schoolMenu() {
        System.out.println("********************************************");
        System.out.println("     **学校管理**     ");
        System.out.println("      1--创建班级      ");
        System.out.println("      2--删除班级      ");
        System.out.println("      3--通过班级名称查询班级信息      ");
        System.out.println("      4--对各班语文成绩按平均分进行由大到小排序      ");
        System.out.println("      5--对各班数学成绩按平均分进行由大到小排序      ");
        System.out.println("      6--显示所有班级名称      ");
        System.out.println("      9--返回上一级菜单      ");
        System.out.println("********************************************");
    }

    // 班级管理菜单
    public void classMenu() {
        System.out.println("********************************************");
        System.out.println("     **班级管理**     ");
        System.out.println("      1--添加学生信息到主学生列表      ");
        System.out.println("      2--添加学生信息到普通班级      ");
        System.out.println("      3--通过学号查询学生信息      ");
        System.out.println("      4--输入班级的语文成绩      ");
        System.out.println("      5--输入班级的数学成绩      ");
        System.out.println("      6--删除学生信息      ");
        System.out.println("      7--显示所有学生信息      ");
        System.out.println("      9--返回上一级菜单      ");
        System.out.println("********************************************");
    }

    // 主业务逻辑
    public void test() {
        TestDemo td = new TestDemo();
        Scanner sc = new Scanner(System.in);
        int input = 0; // 主菜单选择
        int input1 = 0; // 班级管理菜单选择
        int input2 = 0; // 学校管理菜单选择

        // 创建学校对象
        School school = new School();
        // 创建主学生列表
        Class mainStuList = new Class("mainStuList");

        while (true) {
            td.mainMenu();
            System.out.println("请输入对应数字进行列表管理");
            try {
                input = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("输入的不是数字，请重新输入");
                // 当接收数据异常，接收异常数据
                sc.next();
                // 重新执行本次循环
                continue;
            }
            if (input == 0) {
                break;
            } else {
                switch (input) {
                    case 1:
                        // 班级管理列表
                        while (true) {
                            td.classMenu();
                            System.out.println("请输入对应数字进行班级列表管理");
                            try {
                                input1 = sc.nextInt();
                            } catch (java.util.InputMismatchException e) {
                                System.out.println("输入的不是数字，请重新输入");
                                // 当接收数据异常，接收异常数据
                                sc.next();
                                // 重新执行本次循环
                                continue;
                            }
                            if (input1 == 9) {
                                break; // 返回上一层级
                            } else {
                                switch (input1) {
                                    case 1:
                                        // 添加学生信息到主学生列表
                                        System.out.println("添加学生信息到主学生列表中");
                                        System.out.println("请输入要添加的学生信息个数：");
                                        int addNum = 0;
                                        try {
                                            addNum = sc.nextInt();
                                        } catch (Exception e) {
                                            //TODO: handle exception
                                            e.printStackTrace();
                                        }
                                        for (int i = 0; i < addNum; i++) {
                                            System.out.println("请输入第" + (i + 1) + "个学生信息");
                                            System.out.println("请输入学生id：");
                                            String stuId = sc.next();
                                            System.out.println("请输入学生姓名：");
                                            String stuName = sc.next();
                                            // 创建学生对象
                                            Student stu = new Student(stuId, stuName);
                                            mainStuList.addStudent(stu);
                                        }
                                        // 显示
                                        System.out.println("主学生列表的学生信息为：");
                                        mainStuList.displayAllStudent();
                                        break;

                                    case 2:
                                        // 添加学生信息到普通班级
                                        System.out.println("添加学生信息到普通班级");
                                        System.out.println("请输入要添加的班级名称");
                                        String className = sc.next();
                                        // 查询是否存在班级
                                        Class class1 = school.searchClassByName(className);
                                        if (class1 == null) {
                                            System.out.println("未查询到此班级");
                                            break;
                                        } else {
                                            System.out.println("请输入要添加的学生个数：");
                                            addNum = sc.nextInt();
                                            for (int i = 0; i < addNum; i++) {
                                                System.out.println("请输入第" + (i + 1) + "个学生信息");
                                                System.out.println("请输入学生id：");
                                                String stuId = sc.next();
                                                System.out.println("请输入学生姓名：");
                                                String stuName = sc.next();
                                                // 创建学生对象
                                                Student stu = new Student(stuId, stuName);
                                                class1.addStudent(stu);
                                                mainStuList.addStudent(stu);

                                            }
                                            // 显示
                                            System.out.println("主学生列表的学生信息为：");
                                            mainStuList.displayAllStudent();
                                            System.out.println(class1.getClassName() + "班级列表");
                                            class1.displayAllStudent();
                                        }
                                        break;

                                    case 3:
                                        System.out.println("通过学号查询学生信息");
                                        System.out.println("请输入要查询的班级名称：");
                                        className = sc.next();
                                        class1 = school.searchClassByName(className);
                                        if(class1==null){
                                            System.out.println("该班级不存在");
                                            break;
                                        }else{
                                            System.out.println("请输入要查询的学生id");
                                            String stuId = sc.next();
                                            Student stu = class1.searchStudentByNum(stuId);
                                            if(stu==null){
                                                System.out.println("该学生信息在"+className+"不存在");
                                                break;
                                            }else{
                                                System.out.println("学生信息：");
                                                System.out.println(stu);
                                            }
                                        }
                                        break;

                                    case 4:
                                        System.out.println("输入班级语文成绩");
                                        System.out.println("请输入班级的名称");
                                        className = sc.next();
                                        class1 = school.searchClassByName(className);
                                        if(class1==null){
                                            System.out.println("该班级不存在");
                                            break;
                                        }else{
                                            // 判断班级内是否有学生
                                            if(class1.getStuList()==null){
                                                System.out.println("请先向此班级添加学生");
                                                break;
                                            }else{
                                                for(Student stu:class1.getStuList()){
                                                System.out.println(stu);
                                                System.out.println("请输入学生语文成绩");
                                                float score = sc.nextFloat();
                                                class1.insertChineseScore(stu.getStuNum(), score);
                                                }
                                            }
                                            
                                        }
                                        break;

                                    case 5:
                                        System.out.println("输入班级数学成绩");
                                        System.out.println("请输入班级的名称");
                                        className = sc.next();
                                        class1 = school.searchClassByName(className);
                                        if(class1==null){
                                            System.out.println("该班级不存在");
                                            break;
                                        }else{
                                            // 判断班级内是否有学生
                                            if(class1.getStuList()==null){
                                                System.out.println("请先向此班级添加学生");
                                                break;
                                            }else{
                                                for(Student stu:class1.getStuList()){
                                                    System.out.println(stu);
                                                    System.out.println("请输入学生数学成绩");
                                                    float score = sc.nextFloat();
                                                    class1.insertMathScore(stu.getStuNum(), score);
                                                }
                                            }
                                        }
                                        break;

                                    case 6:
                                        System.out.println("删除学生信息");
                                        System.out.println("请输入班级的名称");
                                        className = sc.next();
                                        class1 = school.searchClassByName(className);
                                        if(class1==null){
                                            System.out.println("该班级不存在");
                                            break;
                                        }else{
                                            System.out.println("请输入学生Id：");
                                            String stuNum = sc.next();
                                            Student stu = class1.searchStudentByNum(stuNum);
                                            if(stu==null){
                                                System.out.println("没有找到id:"+stuNum+"的学生信息");
                                                break;
                                            }else{
                                                class1.deleteStudent(stuNum);
                                                mainStuList.deleteStudent(stuNum);
                                            }
                                        }
                                        break;

                                    case 7:
                                        System.out.println("显示所有学生信息");
                                        System.out.println("请输入班级名称");
                                        className = sc.next();
                                        class1 = school.searchClassByName(className);
                                        if(class1==null){
                                            System.out.println("该班级不存在");
                                            break;
                                        }else{
                                            class1.displayAllStudent();
                                        }
                                        break;

                                    default:
                                        System.out.println("输入有误，没有对应的操作");
                                        break;

                                }

                            }

                        }
                        break;

                    case 2:
                        // 学校管理列表
                        while (true) {
                            td.schoolMenu();
                            try {
                                input2 = sc.nextInt();
                            } catch (java.util.InputMismatchException e) {
                                System.out.println("输入的不是数字，请重新输入");
                                // 当接收数据异常，接收异常数据
                                sc.next();
                                // 重新执行本次循环
                                continue;
                            }
                            if (input2 == 9) {
                                break; // 返回上一级
                            } else {
                                switch (input2) {
                                    case 1:
                                        System.out.println("向学校中添加班级");
                                        System.out.println("请输入班级编号");
                                        String classId = sc.next();
                                        System.out.println("请输入班级名称");
                                        String className = sc.next();                                    
                                        Class class1 = new Class(classId, className);
                                        school.addClass(class1);
                                        break;

                                    case 2:
                                        System.out.println("从学校中删除班级");
                                        System.out.println("请输入班级名称");
                                        String className1 = sc.next();
                                        class1 = school.searchClassByName(className1);
                                        if(class1==null){
                                            System.out.println("该班级不存在");
                                            break;
                                        }else{
                                            school.deleteClass(class1);
                                        }
                                        break;
                                    case 3:
                                        System.out.println("通过班级名称查询班级信息");
                                        System.out.println("请输入班级名称");
                                        className1 = sc.next();
                                        class1 = school.searchClassByName(className1);
                                        if(class1==null){
                                            System.out.println("该班级不存在");
                                            break;
                                        }else{
                                            System.out.println(class1);
                                        }
                                        break;

                                    case 4:
                                        System.out.println("对各班语文成绩按平均分进行由大到小排序");
                                        if(mainStuList.getStuList()==null){
                                            System.out.println("还未向班级中添加学生");
                                            break;
                                        }else{
                                            school.sortChineseByAverage();
                                        }
                                        break;

                                    case 5:
                                        System.out.println("对各班数学成绩按平均分进行由大到小排序");
                                        if(mainStuList.getStuList()==null){
                                            System.out.println("还未向班级中添加学生");
                                            break;
                                        }else{
                                            school.sortMathByAverage();
                                        }
                                        break;

                                    case 6:
                                        System.out.println("显示所有班级名称");
                                        System.out.println("所有的班级名称如下：");
                                        school.displayClassName();
                                        break;

                                    default:
                                        System.out.println("输入有误，没有对应的操作");
                                        break;
                                }

                            }

                        }
                        break;

                    default:
                        System.out.println("输入有误，没有对应的操作");
                        break;
                }
            }
            

        }
    }

    public static void main(String[] args) {
        TestDemo td = new TestDemo();
        td.test();

    }
}