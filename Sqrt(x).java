//Sqrt(x)

class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x/2;
        int mid =0;
        if(x == 0){
            return 0;
        }
        if(x == 1 || x == 2 || x == 3){
            return 1;
        }
        if(x==4){
            return 2;
        }
        while(l+1 < r){
            mid = l + (r-l)/2;
            if(mid > x/mid){
                r = mid;
            }
            else if(mid<x/mid){
                l = mid;
            }else{
                return mid;
            }
        }
        if(r <= x/r){
            return r;
        }else{
            return l;
        }
    }
}