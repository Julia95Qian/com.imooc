package exercise02;
public abstract class Animal{
    //按任务要求实现该类
     private String name;
     
     public Animal(){};
     public Animal(String name)
     {
         this.setName(name);
     }
     
     public String getName(){
         return this.name;
     }
     public void setName(String name){
         this.name = name;
     }
     
     abstract void play();
  
 }