/**
 * 类型描述：能够描述员工姓名、工号、年龄、性别、所属部门、职务信息
    要求：
        1、 设定方法限定年龄只能是18--65之间,反之则设置默认为18岁
        2、 设定方法限定性别只能是“男”或者“女”,反之则设置默认为"男"
        3、 设定方法，实现员工自我介绍信息，将员工信息作为字符串返回
 */
package imooc.homework2;

public class Staff{
    private String stfName;
    private String stfNum;
    private int stfAge;
    private String stfSex;
    private Department stfDep;
    private Job stfJob;
    

    // 无参构造
    public Staff(){}
    //有参构造
    public Staff(String stfName, String stfNum, String stfSex, int stfAge, Department stfDep, Job stfJob) {
        this.setStfName(stfName);
        this.setStfNum(stfNum);
        this.setStfSex(stfSex);
        this.setStfAge(stfAge);
        this.setStfDep(stfDep);
        this.setStfJob(stfJob);
    }

    public String getStfName() {
        return stfName;
    }

    public void setStfName(String stfName) {
        this.stfName = stfName;
    }

    public String getStfNum() {
        return stfNum;
    }

    public void setStfNum(String stfNum) {
        this.stfNum = stfNum;
    }

    public int getStfAge() {
        return stfAge;
    }

    public void setStfAge(int stfAge) {
        if(stfAge>=18 && stfAge<=65){
            this.stfAge = stfAge;
        }
        else{
            this.stfAge = 18;
        }
    }

    public String getStfSex() {
        return stfSex;
    }

    public void setStfSex(String stfSex) {
        if(stfSex.equals("男")||stfSex.equals("女")){
            this.stfSex = stfSex;
        }
        else{
            this.stfSex = "男";
        }
    }

    public Department getStfDep() {
        return stfDep;
    }

    public void setStfDep(Department stfDep) {
        this.stfDep = stfDep;
    }

    public Job getStfJob() {
        return stfJob;
    }

    public void setStfJob(Job stfJob) {
        this.stfJob = stfJob;
    }
    
    public String intro(){
        return "姓名："+this.getStfName()+"\n工号："+this.getStfNum()+"\n性别："+this.getStfSex()+"\n年龄："+this.getStfAge()+"\n职务："+this.getStfDep().getDepName()+this.getStfJob().getJobName();
    }
    
}