package practise;

import java.util.Arrays;

public class NO62UniquePath {
    public static void main(String[] args) {
        int paths = new NO62UniquePath().uniquePath2(7, 3);
        System.out.println(paths);
    }

    //二维数组DP解法
    //DP方程:dp[i][j]=dp[i-1][j] + dp[i][j-1]; "上左"之和
    int uniquePaths(int rows, int columns) {
        int[][] grids = new int[rows][columns];
        Arrays.fill(grids[0], 1);
        for (int i = 1; i < rows; i++) {
            grids[i][0] = 1;
            for (int j = 1; j < columns; j++) {
                grids[i][j] = grids[i - 1][j] + grids[i][j - 1];
            }
        }
        return grids[rows - 1][columns - 1];
    }

    //一维数组DP解法
    //DP方程:dp[i]=dp[i] + dp[i-1]; 当前位置与左边之和
    int uniquePath2(int rows, int columns) {
        int[] grids = new int[columns];
        Arrays.fill(grids, 1);
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                grids[j] = grids[j] + grids[j - 1];
            }
        }
        return grids[columns - 1];
    }
}
