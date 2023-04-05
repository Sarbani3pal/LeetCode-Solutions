class Solution {
  public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] start = new int[2];
        int count = 0;//number of 0s and starting point
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    start[0] = i;
                    start[1] = j;
                }
                else if(grid[i][j]==0)
                    count++;
            }
        }
        return helper(grid, start[0],start[1], count+1, new ArrayList<>());
    }
    public int helper(int[][] grid,int i,int j, int count, List<String> visited){
        if(i<0||j<0||i>=grid.length||j>=grid[i].length||grid[i][j]==-1 ||visited.contains(i+" "+j))
            return 0;
        if(grid[i][j]==2)
        {
            if(visited.size()==count)
                return 1;
            return 0;
        }
        visited.add(i+" "+j);
        int rst = 0;
        rst += helper(grid, i+1, j, count, new ArrayList<>(visited));
        rst += helper(grid, i-1, j, count, new ArrayList<>(visited));
        rst += helper(grid, i, j+1, count, new ArrayList<>(visited));
        rst += helper(grid, i, j-1, count, new ArrayList<>(visited));
        return rst;
    }
}