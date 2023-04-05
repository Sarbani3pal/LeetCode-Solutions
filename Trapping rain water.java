//Trapping rain water

class Solution {
    public int trap(int[] height) {
        
        int leftMax = 0;
        int rightMax = 0;
        int[] leftArr = new int[height.length];
        int[] rightArr = new int[height.length];
        
        int i = 0; 
        int j = height.length-1;
        
        while (i<height.length && j>=0) {
            
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax,height[j]);
            leftArr[i++] = leftMax;
            rightArr[j--] = rightMax;
           
        }

        i = 0; 
        for (j = 0;j<height.length; j++) {
     
            i += Math.min(leftArr[j], rightArr[j]) - height[j];
        }
        return i;
    }
}