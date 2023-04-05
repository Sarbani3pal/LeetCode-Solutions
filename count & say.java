//Count & say

class Solution {
    public String countAndSay(int n) {
       return helper("1", 1, n);

    }
    public String helper(String s, int x, int n){
      if(x==n)return s;
       s += "#";
       int count = 1;
       StringBuilder sb = new StringBuilder();
       for(int i=1;i<s.length();i++){
         char c = s.charAt(i);
         if(c==s.charAt(i-1)){
           count++;
           continue;
         }else{
           sb.append(count);
           sb.append(s.charAt(i-1));
           count = 1;
         }
       }
      return helper(sb.toString(), x+1, n);
    }
}