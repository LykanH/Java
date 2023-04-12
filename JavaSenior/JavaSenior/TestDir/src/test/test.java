package test;

import org.junit.Test;

import java.io.File;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/26 16:22
 */
public class test {
    @Test
    public void te(){
        File test = new File("src\\dog.properties");
        System.out.println(test.getAbsolutePath());
    }
}
