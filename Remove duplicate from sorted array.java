class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0;
        for(int i=0; i< nums.length ; i++){
            nums[j] = nums[i];
            
            while(i < nums.length && nums[j] == nums[i] ){
                i++;
            }
            i--;
            j++;
        }
        return j;
        
    }
}