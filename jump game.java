class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return helper(nums,0,dp);
    }
    
    public boolean helper(int[] nums, int pos, Boolean[] dp) {
        if(dp[pos] != null) {
            return dp[pos];
        }
        if(pos >= nums.length) {
            return false;
        }
        if(pos == nums.length-1) {
            return dp[pos] = true;
        }
        int steps = nums[pos];
        for(int i=1; i<=steps; i++) {
            boolean isPossible = helper(nums,pos+i,dp);
            if(isPossible)
                return dp[pos] = true;
        }
        return dp[pos] = false;
    }
}