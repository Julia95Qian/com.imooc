import java.util.ArrayList;
import java.util.List;

public class Class {
    private String classId; // 班级编号
    private String className; // 班级名称
    private List<Student> stuList; // 学生集合

    public Class(String className){
        this.className = className;
        this.stuList = new ArrayList<Student>();
    };

    public Class(String classId, String className) {
        this.classId = classId;
        this.className = className;
        this.stuList = new ArrayList<Student>();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStuList() {
        return stuList;
    }

    public void setStuList(List<Student> stuList) {
        this.stuList = stuList;
    }
    // 将学生添加到班级
    public void addStudent(Student stu){
        // 判断是否已有对象
        boolean flag = false;
        for(Student stu1:stuList){
            if(stu1.equals(stu)){
                flag = true;break;
            }
        }
        if(flag){
            System.out.println("班级已有该同学，添加失败！");
        }else{
            stuList.add(stu);
            System.out.println("添加成功！");
        }
    }
    // 通过学号查询学生在班级中是否存在
    public Student searchStudentByNum(String stuNum){
        Student stu = null;
        for(Student stu1:stuList){
            if(stuNum.equals(stu1.getStuNum())){
                return stu1;
            }
        }
        return stu;
    }
    // 输入班级学生的语文成绩
    public void insertChineseScore(String stuNum, float score){
        // 主业务逻辑中已确认存在该学号学生
        Student stu = searchStudentByNum(stuNum);
        stu.setChinese(score);
        System.out.println("添加语文成绩成功！");
    }
    // 输入班级学生的数学成绩
    public void insertMathScore(String stuNum, float score){
        // 主业务逻辑中已确认存在该学号学生
        Student stu = searchStudentByNum(stuNum);
        stu.setMath(score);
        System.out.println("添加数学成绩成功！");
    }
    // 删除学生信息
    public void deleteStudent(String stuNum){
        // 主业务逻辑判断是否存在该学号学生
        Student stu = searchStudentByNum(stuNum);
        stuList.remove(stu);
        System.out.println("删除成功！");
    }

    // 显示所有学生的信息（包括学号和姓名）
    public void displayAllStudent(){
        if(stuList==null){
            System.out.println("班级内尚无学生！");
        }else{
            // System.out.println("该班所有学生信息如下：");
            for(Student stu:stuList){
                System.out.println(stu);
         }       
        }
    }

    public String toString(){
        return "班级信息：[班级编号："+this.getClassId()+", 班级名称："+this.getClassName()+"]";
    }
}
