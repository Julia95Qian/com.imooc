import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class School implements Comparator<Map.Entry<String,Float>>{
    Map<String,Class> schoolMap;

    public School() {
        schoolMap = new HashMap<String,Class>();
    }

    public Map<String, Class> getSchoolMap() {
        return schoolMap;
    }

    public void setSchoolMap(Map<String, Class> schoolMap) {
        this.schoolMap = schoolMap;
    }
    // 添加班级
    public void addClass(Class class1){
        schoolMap.put(class1.getClassId(), class1);
        System.out.println("添加成功！");
    }
    // 删除班级
    public void deleteClass(Class class1){
        schoolMap.remove(class1.getClassId());
        System.out.println("删除班级成功！");
    }
    // 通过班级名称查询班级
    public Class searchClassByName(String className){
        Class class1 = null;
        Set<String> schoolSet = schoolMap.keySet();
        for(String s:schoolSet){
            if(schoolMap.get(s).getClassName().equals(className)){
                class1 = schoolMap.get(s);break;
            }
        }
        return class1;
    }
   
    //对各班语文成绩按平均分进行由大到小排序
    public void sortChineseByAverage(){
        float chineseTotal;
        float chineseAve;
        Set<String> schoolSet = schoolMap.keySet();
        Map<String, Float> chineseScore = new HashMap<String,Float>();      
         for(String s:schoolSet){
            // 某班学生集合
            List<Student> stuList = schoolMap.get(s).getStuList();
            chineseTotal=0;
            chineseAve=0;
            for(Student stu:stuList){
                chineseTotal = chineseTotal + stu.getChinese();
            }
            // 计算平均分放入集合
            chineseAve = chineseTotal / stuList.size();
            chineseScore.put(s, chineseAve);  
        }
        List<Map.Entry<String,Float>> list = new ArrayList<Map.Entry<String,Float>>(chineseScore.entrySet());
        Collections.sort(list, new School());
        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i).getKey()+"的平均分："+list.get(i).getValue());
        }

    }
    //对各班数学成绩按平均分进行由大到小排序
    public void sortMathByAverage(){
        float mathTotal;
        float mathAve;
        Set<String> schoolSet = schoolMap.keySet();
        Map<String, Float> mathScore = new HashMap<String,Float>();      
         for(String s:schoolSet){
            // 某班学生集合
            List<Student> stuList = schoolMap.get(s).getStuList();
            mathTotal=0;
            mathAve=0;
            for(Student stu:stuList){
                mathTotal = mathTotal + stu.getMath();
            }
            // 计算平均分放入集合
            mathAve = mathTotal / stuList.size();
            mathScore.put(s, mathAve);  
        }
        List<Map.Entry<String,Float>> list = new ArrayList<Map.Entry<String,Float>>(mathScore.entrySet());
        Collections.sort(list, new School());
        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i).getKey()+"的平均分："+list.get(i).getValue());
        }

    }
    // 显示所有班级名称
    public void displayClassName(){
        Set<String> schoolSet = schoolMap.keySet();
        for(String s:schoolSet){
            System.out.println(schoolMap.get(s).getClassName());
        }
    }
    // 重写比较方法
    @Override
    public int compare(java.util.Map.Entry<String, Float> o1, java.util.Map.Entry<String, Float> o2) {
        // TODO Auto-generated method stub
        // 降序排列
        int n;
        if((o1.getValue()-o2.getValue())>0){
            n = -1;
        }else if((o1.getValue()-o2.getValue())<0){
            n = 1;
        }else{
            n=0;
        }
        return n;
    }

}
