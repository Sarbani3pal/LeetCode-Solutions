//Wildcard matching

class Solution {
    public int find(String s,String b,int i,int j,int[][] dp){
        if(j<0 && i<0){
            return 1;
        }
        if(i<0 && j>=0) return 0;
        if(i>=0 && j<0){
            for(int k=0;k<=i;k++){
                if(s.charAt(k)!='*') return 0;
            }
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)=='*'){
            if(find(s,b,i-1,j,dp)==1 || find(s,b,i,j-1,dp)==1){
                return dp[i][j] = 1;
            }
            return dp[i][j] = 0;
        }
        if(s.charAt(i)==b.charAt(j) || s.charAt(i)=='?'){
            return dp[i][j] = find(s,b,i-1,j-1,dp);
        }
        return dp[i][j] = 0;
    }
    public boolean isMatch(String s, String p) {        
        int[][] dp = new int[p.length()][s.length()];
        for(int[] i:dp) Arrays.fill(i,-1);
        return find(p,s,p.length()-1,s.length()-1,dp)==1 ? true : false;
    }
}