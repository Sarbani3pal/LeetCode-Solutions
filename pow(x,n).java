//pow(x,n)

class Solution {
    public double myPow(double x, int n) {
        //binary exponentiation
    double ans =1.0;
        long nn=n;// to stor the value of n as we will be manipulating it
        if(nn<0)
            nn=-1*nn;// to make it positive. can't calculate negative powers directly.
        while(nn>0){
            if(nn%2==1){ //if power is odd
                ans=ans*x;
                nn=nn-1;
            }
            else{       //if even 
                x=x*x;
                nn=nn/2;
            }
        }
        if(n<0)       //if power is negative , divide by 1
            ans=(double)1.0/(double)(ans);
        return ans;
    
    }


}