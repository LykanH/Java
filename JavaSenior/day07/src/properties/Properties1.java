package properties;

import java.io.*;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/26 10:48
 */
public class Properties1 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            File file = new File("day07\\src\\mysql.properties");
            br = new BufferedReader(new FileReader(file));
            String temp = "";
            while((temp = br.readLine()) != null){
                String[] split = temp.split("=");
                System.out.println(split[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
