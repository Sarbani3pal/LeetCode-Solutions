//3sum closest

class Solution {

public int threeSumClosest(int[] nums, int target) {
   // same as 3 sum but we need to compare the sums 
   Arrays.sort(nums);
   int closestSum=nums[0]+nums[1]+nums[nums.length-1];     
   for(int i=0;i<nums.length-2;i++){
       int lo=i+1;
       int hi=nums.length-1;
       while(lo<hi){
           int newSum=nums[i]+nums[lo]+nums[hi];
           if(newSum<target){
               lo++;     
           }
            else{
              hi--;
            }
           if(Math.abs(newSum-target)<Math.abs(closestSum-target)) closestSum=newSum;   
       }    
   }
     return closestSum;   
}
}