//Jump gate II

class Solution {
    public int jump(int[] nums) {
        //Create a DP array to store the minimum number of jumps 
        int n = nums.length;
        int []dp = new int [n];
        
        Arrays.fill(dp,Integer.MAX_VALUE);        
        //Fill all the elements with Max Integer Initially
        
        
        dp[n-1] = 0; //last position doesn't have any jumps to reach as it is an end.
        
        
        //Now Starting from reverse i.e making the problem smaller, the last position to reach end would be 1 and similarly building the dp array.
        for(int i = n - 2; i>=0; i--){
            int steps = nums[i];
            int min = Integer.MAX_VALUE;            
            
            for(int j = 1 ; j <= steps && i+j < n; j++){
                if(dp[i+j] < min){
                    min = dp[i+j];
                }
            }
            if(min != Integer.MAX_VALUE){
                dp[i] = min + 1;
            }
            
        }
        return dp[0];// Since we need to find from the start 
    }
}