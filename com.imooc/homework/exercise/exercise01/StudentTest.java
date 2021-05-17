package exercise01;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class StudentTest {
    public static void main(String[] args) {
		//定义三个Student类的对象及一个HashSet类的对象
        Student st1 = new Student(3, "William", 65);
        Student st2 = new Student(1, "Tom", 87);
        Student st3 = new Student(2, "Lucy", 95);
        Student st4 = new Student(2, "Lucy", 95);
        // 引入泛型
        Set<Student> set = new HashSet<>();
		//将Student类的对象添加到集合中
        set.add(st1);
        set.add(st2);
        set.add(st3);
        // 重复元素是否输出
        set.add(st4);
		//使用迭代器显示Student类的对象中的内容
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    
    
	}
}