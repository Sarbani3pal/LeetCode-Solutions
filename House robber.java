class Solution {
    public int rob(int[] nums) {
		// to compute for n as below structure
        // {... leftLeftRob, leftRob, n, n + 1, n + 2,...}
        int leftLeftRob = 0;
        int leftRob = 0;
        for(int num : nums) {
            int temp = Math.max(num + leftLeftRob, leftRob);
            leftLeftRob = leftRob;
            leftRob = temp;
        }
        return leftRob;
    }
}