/**
 * 类型描述：测试程序，并参照效果图输出结果
 */
package imooc.homework2;

public class Test {
    public static void main(String[] args){
        Staff[] stf = new Staff[6];

        Job j1 = new Job("P001","经理");
        Job j2 = new Job("P002","助理");
        Job j3 = new Job("P003","职员");

        Department d1 = new Department("D001","人事部", stf);
        Department d2 = new Department("D002","市场部", stf);

        Staff s1 = new Staff("张铭","S001","男",29, d1, j1);
        Staff s2 = new Staff("李艾爱","S002","女",21, d1, j2);
        Staff s3 = new Staff("孙超","S003","男",29, d1, j3);
        Staff s4 = new Staff("张美美","S004","女",26, d2, j2);
        Staff s5 = new Staff("蓝迪","S005","男",37, d2, j1);
        Staff s6 = new Staff("米莉","S006","女",24, d2, j3);

        stf[0] = s1;
        stf[1] = s2;
        stf[2] = s3;
        stf[3] = s4;
        stf[4] = s5;
        stf[5] = s6;



        for(int i=0; i<6; i++)
        {
            String str = stf[i].intro();
            System.out.println(str);
            System.out.println("=====================");
        }
        d1.countStaff(s1);
        d1.countStaff(s2);
        d1.countStaff(s3);
        System.out.println("人事部总共有"+d1.getStfNum()+"名员工");
        d2.countStaff(s4);
        d1.countStaff(s5);
        d1.countStaff(s6);
        System.out.println("市场部总共有"+d2.getStfNum()+"名员工");
    }
}
