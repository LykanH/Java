package exer_1;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/5 14:30
 *
 *
 * 获取文本上每个字符出现的次数
 *
 *      提示：遍历文本每一个字符；字符及出现的次数保留在Map中；将Map中数据写入文件
 *
 */
public class CodeAppend {
    @Test
    public void codeAppend(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        HashMap<Character,Integer> hashMap = null;
        try {
            hashMap =  new HashMap<Character,Integer>();

            br = new BufferedReader(new FileReader(new File("english.txt")));
            bw = new BufferedWriter(new FileWriter(new File("englishStatistics.txt")));

            char[] chars = new char[100];
            int read;
            while ((read = br.read(chars)) != -1){
                for (int i = 0;i < read;i++){
                    if (!(hashMap.containsKey(chars[i]))){
                        hashMap.put(chars[i],1);
                    }else {
                        hashMap.put(chars[i],(hashMap.get(chars[i])+1));
                    }
                }
            }
            System.out.println("统计成功！");

            Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();
            Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                bw.write(entry.getKey() + "--->" + entry.getValue() + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null)
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    if (bw != null)
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }

//        Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();
//        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry)iterator.next();
//            System.out.println(entry.getKey() + "--->" + entry.getValue());
//        }

    }
}
