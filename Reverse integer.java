//Reverse integer

class Solution {
    public int reverse(int x) {
        long number = 0 ;

        if(x < Math.pow(-2,31)  || x > (Math.pow(2,31)-1)){
            return 0 ;
        }
        if(x>0){
            while(x>0){
                int reminder = x%10 ;
                number = number + reminder ;
                number = number*10 ;
                x = x/10 ;
            }
            if(number/10 >= Math.pow(-2,31)  && number/10 < (Math.pow(2,31))){
                return (int)(number/10) ;
            }
            	return 0;
        }
        else if(x< 0){
            x = x*(-1);
            while(x>0){
                int reminder = x%10 ;
                number = number + reminder ;
                number = number*10 ;
                x = x/10 ;
            }
            if(number/10 >= Math.pow(-2,31)  && number/10 <= (Math.pow(2,31)-1)){
                return (int)(number/10)*(-1) ;
            }
            	return 0;
        }
        
        return (int)number ;
    }
}