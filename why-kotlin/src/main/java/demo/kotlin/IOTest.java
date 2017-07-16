package demo.kotlin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by gemhuang on 2017/7/16.
 */
public class IOTest {
    public static void main(String[] args){
        File file = new File(args[0]);

        try {
            FileInputStream fis = new FileInputStream(file);
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
