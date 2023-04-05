class Solution {
    public boolean isvalid(String a,String b){
        int i=0;
        int cnt=1;
        while(i<a.length()){
            if(a.charAt(i) != b.charAt(i)){
                if(cnt==0)return false;
                cnt--;
            }
            i++;
        }
        return true;
    } 
    public int minMutation(String start, String end, String[] bank) {
        /*
          bank used to reach the end
           BFS
           
           Time complexity:0(bank.length * bank.length * word.length)
        */
        Queue<String>q=new LinkedList<>();
        q.add(start);
        int level=0;
        Set<String>set=new HashSet<>();
        set.add(start);
        
        while(!q.isEmpty()){
            int size=q.size();
            
            while(size-->=1){
                String tmp=q.remove();
                
                if(tmp.equals(end))return level;
                
                for(int i=0;i<bank.length;i++)
                {
                    if(!set.contains(bank[i]) && isvalid(tmp,bank[i])){
                        set.add(bank[i]);
                        q.add(bank[i]);}
                }
            }
            level++;
        }
        return -1;
    }
}