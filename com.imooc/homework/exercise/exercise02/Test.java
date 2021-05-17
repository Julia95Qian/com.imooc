package exercise02;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
		//定义List并添加Dog类对象
	    List<Dog> dg = new ArrayList<Dog>();
	    dg.add(new Dog("巴迪"));
	    dg.add(new Dog("豆豆"));
	    
		//定义List并添加Cat类对象
	    List<Cat> ct = new ArrayList<Cat>();
	    ct.add(new Cat("花花"));
	    ct.add(new Cat("凡凡"));
    
		//使用AnimalPlay类的方法，按照演示效果输出内容
		
        AnimalPlay ap = new AnimalPlay();
        ap.play(dg);
        ap.play(ct);
        
	}
}
