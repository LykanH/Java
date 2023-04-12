package PaintTest;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/15 10:39
 */
public class WorkTest {
    @Test
    public void workTest() {
        ArrayList coll = new ArrayList();
        for (int i = 0; i < 3; i++) {
                coll.add(i);
        }

        for (int i = 0; i < coll.size(); i++) {
            System.out.println(coll.get(1));
        }
    }

    @Test
    public void HeartTest1(){
        float x,y,a;
        for(y=1.5f;y>-1.5f;y-=0.15f){
            for(x=-1.5f;x<=1.5f;x+=0.05f){
                a=x*x+y*y-1;
                System.out.print(a*a*a-x*x*y*y*y<=0.0f?'x':' ');
            }
            System.out.println();
        }
    }

    @Test
    public void HeartTest2(){
//        String s1;
//        System.out.print("---------------输入你喜欢人的名字---------------：");
//        s1 = new Scanner(System.in).nextLine();
//        if (s1 == "谢和香" || s1 == "杨鹏博") {
            int count = 0;
            for (float y = 2.5f; y > -2.0f; y -= 0.12f) {
                for (float x = -2.3f; x < 2.3f; x += 0.041f) {
                    float a = x * x + y * y - 4f;
                    if ((a * a * a - x * x * y * y * y) < -0.0f) {
                        String str = "I LOVE YOU!";
                        int num = count % str.length();
                        System.err.print(str.charAt(num));
                        count++;
                    } else {
                        System.err.print(" ");
                    }
                }
                System.err.println();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
//        }else {
//            System.out.println("你输入的名字不是谢和香和杨鹏博，请重新输入！");
//        }
    }
}
