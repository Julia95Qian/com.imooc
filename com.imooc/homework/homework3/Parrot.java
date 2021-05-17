package imooc.homework3;

public class Parrot extends Animal implements IAct {
    private String type;

    public Parrot() {
    };

    public Parrot(String name, int age, String type) {
        super(name, age);
        this.setType(type);;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String love() {
        // TODO Auto-generated method stub
        return "喜欢吃坚果和松子";
    }

    @Override
    public void act() {
        // TODO Auto-generated method stub
        System.out.println("表演者:"+super.getName());
        System.out.println("年龄:"+super.getAge()+"岁");
        System.out.println("品种:"+this.getType());
        System.out.println("技能:"+this.skill());
        System.out.println("爱好:"+this.love());
    }

    @Override
    public String skill() {
        // TODO Auto-generated method stub
        return "擅长模仿";
    }

    
    
}
