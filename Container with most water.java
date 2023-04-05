//container with most water

lass Solution {
    public int maxArea(int[] height) {
        
        int l=0, r=height.length-1;
        int tw=0;
        
        while(l<r){
            tw = Math.max(tw, Math.min(height[l], height[r])*Math.abs(r-l));
            if(height[l]<=height[r])l++;
            else r--;
        }
        
        return tw;
    }
    
}