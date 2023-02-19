package test;

import org.junit.Test;

import java.io.*;
import java.util.Random;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/18 10:06
 *
 *
 */
public class Test5 {
    @Test
    public void test1(){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File("temp.txt"),false));

            Random r1 = new Random();
            int i = 0;
            while(i < 100) {
                int a = (int) (Math.random() * 5);
                if(i > 0 && i%10 ==0) {
                    System.out.println();
                    bw.write("\n");
                }
                System.out.print(a + "\t");
                bw.write(a + "\t");
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
