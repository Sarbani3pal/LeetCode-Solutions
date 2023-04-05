//Insertion of 2 array

class Solution {
    // Total Time: O(n) + O(m) 
    // Total Space: O(n) + min(O(n), O(m))
    public int[] intersect(int[] nums1, int[] nums2) {
        // Space: O(n). where n is the length of nums1
        Map<Integer, Integer> nums1Map = new HashMap<>();
        
        // Time: O(n). where n is the length of nums1
        for(int num: nums1){
            if(!nums1Map.containsKey(num)){
                nums1Map.put(num, 0);
            }
            
            nums1Map.put(num, nums1Map.get(num)+1);
        }
        
        // Space: min(O(n), O(m)). where n is the length of nums1 & m is the length of nums2
        int[] intersectionList = new int[Math.min(nums1.length, nums2.length)];
        int i=0;
        
        // Time: O(m). where m is the length of nums2
        for(int num: nums2){
            if(!nums1Map.containsKey(num) || nums1Map.get(num) == 0){
                continue;
            }
            
            intersectionList[i++] = num;
            nums1Map.put(num, nums1Map.get(num)-1);
        }
        
        return Arrays.copyOfRange(intersectionList, 0, i);
    }
}