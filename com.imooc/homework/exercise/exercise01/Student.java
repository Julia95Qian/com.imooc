package exercise01;
public class Student{
    //根据需求完成Student类的定义
    private int stuId;
     private String name;
     private float score;
     
     public Student(){};
     public Student(int stuId, String name, float score){
         this.setStuId(stuId);
         this.setName(name);
         this.setScore(score);
     }
     
     public void setStuId(int stuId){
         this.stuId = stuId;
     }
     public int getStuId(){
         return this.stuId;
     }
     public void setName(String name){
         this.name = name;
     }
     public String getName(){
         return this.name;
     }
      public void setScore(float score){
         this.score = score;
     }
     public float getScore(){
         return this.score;
     }

     @Override
     public int hashCode() {
         final int prime = 31;
         int result = 1;
         result = prime * result + ((name == null) ? 0 : name.hashCode());
         result = prime * result + Float.floatToIntBits(score);
         result = prime * result + stuId;
         return result;
     }

     @Override
     public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        else if(obj.getClass()==Student.class){
            Student stu = (Student)obj;
            return (stu.getName().equals(name)) && (stu.getStuId()==stuId) && (stu.getScore()==score);
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "[学号:" + stuId + ", 姓名：" + name + ",成绩：" + score + "]";
    }
 
 }