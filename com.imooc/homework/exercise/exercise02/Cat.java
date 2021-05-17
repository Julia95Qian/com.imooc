package exercise02;

public class Cat extends Animal{
    public Cat(String name) {
        super.setName(name);
	}
    //按任务要求实现该类
    void play(){
        System.out.println("小猫"+super.getName()+"在做游戏！");
    }
}