package DP;

/**
 * JZ47 礼物的最大价值
 * 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class dp9 {
    public int maxValue (int[][] grid) {
        int[][] dp=new int[205][205];
        dp[1][1]=grid[0][0];
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j])+grid[i][j];
            }
        }
        return dp[grid.length][grid[0].length];
    }
}
