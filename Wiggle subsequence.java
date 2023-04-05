//Wiggle subsequence

class Solution 
{
    public int wiggleMaxLength(int[] nums) 
    {
        if (nums.length <= 1) 
            return nums.length;
    
        int ans = nums.length;
        Boolean sign = null;
    
        for (int i = 0; i < nums.length-1; i++)
        {
            int temp = nums[i+1] - nums[i];
            if (temp == 0) 
                ans--;//when we encounter a diff of 0, we decrement the ans i.e we don't consider that element in our answer sequence
            
            else if (sign == null) //this means we havent encountered any difference yet
                sign = temp > 0;
            
            
            else if ((temp > 0 && sign) || (temp < 0 && !sign))
                ans--;
            
            else
                sign = !sign;//else just toggle the sign
        }
        return ans;
    }
}