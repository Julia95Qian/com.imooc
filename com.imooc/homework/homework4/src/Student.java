public class Student {
    private String stuNum; // 学号
    private String stuName; // 姓名
    private float math; // 数学成绩
    private float chinese; // 语文成绩

    public Student(){};
    public Student(String stuNum, String stuName) {
        this.stuNum = stuNum;
        this.stuName = stuName;
    }
    
    public Student(String stuNum, String stuName, float math, float chinese) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.math = math;
        this.chinese = chinese;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getChinese() {
        return chinese;
    }

    public void setChinese(float chinese) {
        this.chinese = chinese;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(chinese);
        result = prime * result + Float.floatToIntBits(math);
        result = prime * result + ((stuName == null) ? 0 : stuName.hashCode());
        result = prime * result + ((stuNum == null) ? 0 : stuNum.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj.getClass()==Student.class){
            Student student = (Student)obj;
            return((student.getStuNum().equals(this.getStuNum())) && 
                    (student.getStuName().equals(this.getStuName())) && 
                    (student.getMath()==this.getMath()) && 
                    (student.getChinese()==this.getChinese()));
        }
        return false;
    }

    @Override
    public String toString() {
        return "[学号：" + this.getStuNum() + ", 姓名" + this.getStuName() +"]";
    }
    



    

    
}
