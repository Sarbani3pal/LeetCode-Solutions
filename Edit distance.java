//Edit distance

class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int[][]dp=new int[n1+1][n2+1];
        
        for(int[]a:dp)Arrays.fill(a,-1);
        
        return helper(word1,word2,n1-1,n2-1,dp);
    }
    
    public int helper(String s1,String s2,int i,int j,int[][]dp){
        if(j<0) return i+1;
        if(i<0) return j+1;
        if(dp[i][j]!=-1)return dp[i][j];
        int sum=0;
        if(s1.charAt(i)==s2.charAt(j))
            sum=0+helper(s1,s2,i-1,j-1,dp);
        else{
            int ins=helper(s1,s2,i,j-1,dp);
            int del=helper(s1,s2,i-1,j,dp);
            int rep=helper(s1,s2,i-1,j-1,dp);
            sum=1+Math.min(ins,Math.min(del,rep));
        }
        
        return dp[i][j]=sum;
    }
}