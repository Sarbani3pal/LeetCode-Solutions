class Solution {
    public void find(int[][]A,Queue<int[]>q,Set<String>set){
        int[]dx={-1,1,0,0};
        int[]dy={0,0,-1,1};
        while(!q.isEmpty()){
            int[]tmp=q.remove();
            
            for(int i=0;i<4;i++){
                int newx=tmp[0]+dx[i];
                int newy=tmp[1]+dy[i];
                
                if(newx >=0 && newy>=0 && newx < A.length && newy < A[0].length && !set.contains(String.valueOf(newx)+"#"+String.valueOf(newy)) && A[tmp[0]][tmp[1]] <= A[newx][newy]){
                set.add(String.valueOf(newx)+"#"+String.valueOf(newy));
                q.add(new int[]{newx,newy});
            }
            
           }
        }
            
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<String>f=new HashSet<>();
        Set<String>s=new HashSet<>();
        
        Queue<int[]>q1=new LinkedList<>();
        Queue<int[]>q2=new LinkedList<>();
        
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++)
            {
                if(i==0 || j==0){
                    s.add(String.valueOf(i)+"#"+String.valueOf(j));
                    q1.add(new int[]{i,j});}
                 if(i==heights.length-1 || j==heights[0].length-1){
                    f.add(String.valueOf(i)+"#"+String.valueOf(j));
                    q2.add(new int[]{i,j});}
            }
        }
        
        find(heights,q1,s);
        find(heights,q2,f);
        
        List<List<Integer>>res=new ArrayList<>();
        
        for(String k:s){
            if(f.contains(k)){
                String[]tmp=k.split("#");
                List<Integer>l=new ArrayList<>();
                l.add(Integer.valueOf(tmp[0]));
                l.add(Integer.valueOf(tmp[1]));
                res.add(l);
            }
        }
        return res;
    }
}