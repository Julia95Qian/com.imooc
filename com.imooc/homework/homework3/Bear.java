package imooc.homework3;

public class Bear extends Animal implements IAct{

    public Bear() {
    }

    public Bear(String name, int age) {
        super(name, age);
    }
    public String skill(){
        return "挽着花篮，打着雨伞，自立走秀";
    }
    public String love(){
        return "喜欢卖萌";
    }

    public void act(){
        System.out.println("表演者:"+super.getName());
        System.out.println("年龄:"+super.getAge()+"岁");
        System.out.println("技能:"+this.skill());
        System.out.println("爱好:"+this.love());
    }

}
