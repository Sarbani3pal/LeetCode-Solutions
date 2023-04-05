//Longest consecutive swquence

class Solution {

public int longestConsecutive(int[] nums) {
    
    Arrays.sort(nums);
    
    int size=0;
    int maxSize=0;
    
    for(int i=0;i<nums.length;){
        int j=i+1;
        size=1;
        while(j<nums.length){
            if(nums[j]==nums[j-1]+1){
                j++;
                size++;
            }else if(nums[j]==nums[j-1])
                j++;
            else
                break;
        }
        maxSize=Math.max(size,maxSize);
        i=j;
    }
    
    return maxSize;
}
}