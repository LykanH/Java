package ICPC;

/**
 * @author muchen
 * @create 2023 - 04 - 2023/4/12 8:52
 */

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有
 * 的'O' 用 'X' 填充。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。 任何不在边界上，
 * 或不与边界上的'O'相连的'O'最终都会被填充为'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 * <p>
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 */
public class Main_5 {
    boolean
    public static void main(String[] args) {
        char[][] board = new char[4][4];
        solve(board);
    }
    static public void solve(char[][] board) {

    }
}


class P1 {
    int x;
    int y;

    public P1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
