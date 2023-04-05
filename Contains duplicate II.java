class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        if(nums.length==1)
            return false;
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],i);
            else if(map.containsKey(nums[i])&&(Math.abs(map.get(nums[i]) - i)>k))    
                map.replace(nums[i],i);
            else if(Math.abs(map.get(nums[i]) - i)<=k)
                return true;
        }
        return false;
    }
}