package exercise02;
public class Dog extends Animal{
    public Dog(String name) {
        super.setName(name);
	}

//按任务要求实现该类
   void play(){
       System.out.println("小狗"+super.getName()+"在做游戏！");
   }

}
