class Solution {
    public static int[][] dp;
    static{
        dp = new int[100][100];
        for(int i =0;i<100;i++)
        {
            dp[0][i] = 1;
            dp[i][0] = 1;
        }
        for(int i = 1;i<100;i++)
        {
            for(int j = 1;j<100;j++)
            {
                dp[i][j] = dp[i-1][j]+ dp[i][j-1];
            }
        }
    }
    public int uniquePaths(int m, int n) {
        return dp[m-1][n-1];
    }
}