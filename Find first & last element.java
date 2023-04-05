class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1,-1};
        arr[0] = index(nums,target,true);
        if(arr[0] !=-1){
            arr[1] = index(nums,target,false);
        }
        
        
        return arr;
    }
    
    int index(int[] arr, int target, boolean isfirst){
        int start = 0;
        int ans = -1;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(arr[mid]>target){
                end = mid-1;
            }else if(arr[mid]<target){
                start = mid+1;
            }else{
                ans = mid;
                if(isfirst){
                    end = mid-1;
                }else{
                    start = mid +1;
                }
            }
        }
         
        return ans;
    }
}