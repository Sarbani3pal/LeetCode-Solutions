class Solution {
    public int lengthOfLIS(int[] nums) {
int n = nums.length;
int[][] dp = new int[n][n+1];
return solve(0, -1, nums, dp);
}
int solve(int ind, int previ, int[] nums, int[][] dp){
if(ind==nums.length)
return 0;
if(dp[ind][previ+1] > 0)
return dp[ind][previ+1];
int len = solve(ind+1, previ, nums, dp);
if(previ==-1 || nums[ind]>nums[previ])
len = Math.max(len, 1 + solve(ind+1, ind, nums, dp));
return dp[ind][previ+1] = len;
}
}