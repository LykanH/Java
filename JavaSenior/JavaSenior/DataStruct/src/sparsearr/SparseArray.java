package sparsearr;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/22 13:07
 * 将棋盘看成二维数组
 * 二维数组转化为稀疏数组，稀疏数组转化为二维数组的实现过程！
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;

        System.out.println("初始数组为如下...");
        for (int[] ints : chessArray) {
            for (int a : ints) {
                System.out.printf("%d\t", a);
            }
            System.out.println();
        }
        System.out.println();

        //二维数组转化为稀疏数组
        int notZeroNum = 0;
        for (int[] ints : chessArray) {
            for (int a : ints) {
                if (a != 0) {
                    notZeroNum++;
                }
            }
        }
//        System.out.println("notZeroNum = " + notZeroNum);

        int[][] sparseArray = new int[notZeroNum + 1][3];
        sparseArray[0][0] = chessArray.length;
        sparseArray[0][1] = chessArray[1].length;
        sparseArray[0][2] = notZeroNum;

        int count = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println("稀疏数组为...");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }

        //将稀疏数组转化为原始二维数组

        int[][] chessArray_1 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1;i<sparseArray.length;i++){
            chessArray_1[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //原二维数组输出
        System.out.println();
        System.out.println("原二维数组为...");
        for (int[] ints : chessArray_1) {
            for (int a : ints) {
                System.out.printf("%d\t", a);
            }
            System.out.println();
        }
    }
}
