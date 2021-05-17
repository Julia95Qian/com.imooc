package imooc.homework3;

public class Lion extends Animal implements IAct {
    private String color;
    private String sex;


    public Lion(){};
    public Lion(String name, int age){
        super(name, age);
    }
    // 四参构造方法
    public Lion(String name, int age, String color, String sex){
        super(name, age);
        this.setColor(color);
        this.setSex(sex);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    @Override
    public String love() {
        // TODO Auto-generated method stub
        return "喜欢吃各种肉类";
    }


    @Override
    public String skill() {
        // TODO Auto-generated method stub
        return "擅长钻火圈";
    }

    @Override
    public void act() {
        // TODO Auto-generated method stub
        System.out.println("表演者:"+super.getName());
        System.out.println("年龄:"+super.getAge()+"岁");
        System.out.println("性别:"+this.getSex()+"狮");
        System.out.println("毛色:"+this.getColor());
        System.out.println("技能:"+this.skill());
        System.out.println("爱好:"+this.love());
    }
    
    
}
