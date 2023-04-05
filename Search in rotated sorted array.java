//Search in rotated sorted array

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return -1;
        

        int low = 0;
        int high = nums.length-1;
 
        while(low <= high){
            
            int mid = low + (high-low)/2; 
                
            if(nums[mid] == target)
                return mid;
            
            // left side sorted
            
            if(nums[low] <= nums[mid]){
                // target on sorted side
                if(nums[low] <= target && nums[mid] > target)
                    high = mid-1;
                
                // target on unsorted side
                
                else
                    low = mid +1;
            }
            
            // right side sorted
            
            else if(nums[mid] <= nums[high]){
                
                //target on sorted side
                
                if(nums[mid] < target && nums[high] >= target)
                    low = mid+1;
                
                else
                    high = mid-1;
                    
            }
            
        }
        
        return -1;
            
    }
}