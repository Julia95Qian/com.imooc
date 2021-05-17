package exercise03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class speechTest {
    public static void main(String[] args){
        System.out.print("文本内容：");
        int count = 0;
        try {
        FileInputStream fis = new FileInputStream("speech.txt");
        int n;
        while((n=fis.read())!=-1){
            System.out.print((char)n);
            count ++;
        }
        fis.close();
        
    } catch (FileNotFoundException e) {
        //TODO: handle exception
        e.printStackTrace();
    } catch (IOException ex){
        ex.printStackTrace();
    }
    System.out.println();
    System.out.println("统计结果：speech.txt文件中共有" + count + "字节");
}
}

