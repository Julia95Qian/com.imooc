/**
 * 类型描述：能够描述部门编号、部门名称、员工数组、统计部门中的员工个数

    要求：设定方法统计该部门员工个数
 */
package imooc.homework2;

public class Department {
   private String depNum;
   private String depName;
   private Staff[] stf;
   //private String[] stfStr = new String[200]; //员工姓名
   private int stfNum; //员工人数

   // 无参构造方法
   public Department(){};

   // 有参构造方法
   public Department(String depNum, String depName){
      this.setDepNum(depNum);
      this.setDepName(depName);
   }

   // 有参构造方法
   public Department(String depNum, String depName, Staff[] stf){
      this.setDepNum(depNum);
      this.setDepName(depName);
      this.setStaff(stf);
   }
   
   public String getDepNum() {
      return depNum;
   }

   public void setDepNum(String depNum) {
      this.depNum = depNum;
   }

   public String getDepName() {
      return depName;
   }

   public void setDepName(String depName) {
      this.depName = depName;
   }


   public void setStaff(Staff[] stf){
      this.stf = stf;
   }
   // 获取员工信息
   public Staff[] getStaff(){
      if(this.stf==null){
         this.stf = new Staff[200];
      }
      return stf;
   }

   public int getStfNum() {
      return stfNum;
   }

   public void setStfNum(int stfNum) {
      this.stfNum = stfNum;
   }
   
   // 统计人数方法
   public void countStaff(Staff staff){
      for(int i=0; i<this.getStaff().length; i++){
         if(this.getStaff()[i]==null){
            this.getStaff()[i] = staff;
            this.stfNum = this.stfNum+1;
            break;
         }
      }
   }

    
}
