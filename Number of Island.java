class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        
        int[][] visited = new int[m][n];
        
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '0'){
                    continue;
                } else {
                    
                    count += dfs(grid, i, j, visited);
                }
            }
        }
        
        return count;
    }
    
    public int dfs(char[][] grid, int i, int j, int[][] visited){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == 1){
            return 0;
        }
        
        if(grid[i][j] == '0'){
            return 0;
        }
        
        visited[i][j] = 1;
        
        
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j - 1, visited);
        
        return 1;
    }
}