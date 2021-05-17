package imooc.homework3;

public class Clown implements IAct {
    private String name;
    private int years;

    public Clown() {
    };

    public Clown(String name, int years) {
        this.setName(name);
        this.setYears(years);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    };

    public String dress() {
        return "身穿五彩服装，头上戴着彩色的帽子，脸上画着夸张的彩妆";
    }

    @Override
    public void act() {
        // TODO Auto-generated method stub
        System.out.println("表演者:"+this.getName());
        System.out.println("艺龄:"+this.getYears()+"年");
        System.out.println("着装:"+this.dress());
        System.out.println("技能:"+this.skill());
    }

    @Override
    public String skill() {
        // TODO Auto-generated method stub
        return "脚踩高跷，进行杂技魔术表演";
    }

}
