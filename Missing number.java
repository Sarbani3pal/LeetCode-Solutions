//Missing missingNumber

class Solution {
//O(N)
public int missingNumber(int[] nums) {
if (nums == null || nums.length == 0) {
return -1;
}

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
    }
	//Sum of N natural numbers
    int totSum = (nums.length * (nums.length + 1)) / 2;

    return totSum - sum;
}
}