public class Solution extends GuessGame {
public int guessNumber(int n) {
int low=1,high=n,g=0;
while(low<=high){
int mid = low +(high-low)/2;
g=guess(mid);
if(g==0)
return mid;
if(g==1)
low =mid+1;
else high =mid-1;
}
return 0;
}
}