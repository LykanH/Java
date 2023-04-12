package TankGame7;

import java.io.*;
import java.util.Vector;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/28 18:00
 * 该类用于记录游戏数据，将游戏数据存入磁盘中，使游戏可以继续
 */
@SuppressWarnings("all")
public class Recorder {
    private static int shotEnemyNum = 0;//记录我方坦克击败多少个敌方坦克
    static BufferedWriter bw = null;

    static BufferedReader br = null;//用于读取文件内容
    private static Vector<Enemy> enemies = null;//该属性指向的是Mypanel中的敌人向量 方法为设置set方法，在Mypanel中调用
    private static Vector<Node> nodes = new Vector<>();//用于恢复上局游戏数据

    public static Vector<Node> getShotEnemyNumAndEnemyInfo(){
        try {
            br = new BufferedReader(new FileReader(new File("JavaSenior\\tankegame\\src\\myRecord.txt")));
            shotEnemyNum = Integer.parseInt(br.readLine());
            String str = "";
            while ((str = br.readLine())!=null){
                String[] split = str.split(" ");//将数据读出 并存入存放Node节点的集合中
//                nodes.add(new Node(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2])));
                nodes.add(new Node(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return nodes;
    }


    public static void setEnemies(Vector<Enemy> enemies) {
        Recorder.enemies = enemies;
    }

    //该方法将击败坦克数据存入文件中
    public static void storeEnemyNum() {
        try {
            bw = new BufferedWriter(new FileWriter(new File("JavaSenior\\tankegame\\src\\myRecord.txt")));
            bw.write(shotEnemyNum + "\n");
            bw.flush();
            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                if (enemy.isLive() != false) {
                    String info = enemy.getX() + " " + enemy.getY() + " " + enemy.getDirect() +"\n";
                    bw.write(info);
                    bw.flush();
                }
            }
//            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static int getShotEnemyNum() {
        return shotEnemyNum;
    }

    public static void setShotEnemyNum(int shotEnemyNum) {
        Recorder.shotEnemyNum = shotEnemyNum;
    }

    public static void insertEnemyNum() {
        shotEnemyNum++;
    }
}
