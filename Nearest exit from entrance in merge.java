class Solution {
    final int[] rows = {-1 , 0 , 1 , 0} ;
    final int[] cols = {0 , 1 , 0 , -1} ;
    
    public int nearestExit(char[][] maze, int[] entrance) {
         int m = maze.length ;
         int n = maze[0].length ;
        int curr_x = entrance[0] ;
        int curr_y = entrance[1] ;
        
        
        int[][] visited = new int[m][n] ;
        for(int[] arr : visited)
            Arrays.fill(arr , -1) ;
        
        Queue<int[] > ue = new LinkedList<>() ;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    if(maze[i][j] == '.'){
                        
                        if(i == curr_x && j == curr_y)
                            continue ;
                        
                        ue.add(new int[]{i , j} );
                        visited[i][j]  = 0 ;
                    }
                }
            }
        }
        
        if(ue.size() == 0)
            return -1 ;
        
        while(! ue.isEmpty() ){
            int[] curr = ue.peek() ;
            ue.poll() ;
            
            int i = curr[0] ;
            int j = curr[1] ;
            
            for(int k = 0 ; k < 4 ; k++){
                int x = i + rows[k] ;
                int y = j + cols[k] ;
                
                if(x < 0 || y < 0 || x >= m || y >= n || maze[x][y] == '+' ||
                  visited[x][y] != -1)
                    continue ;
                
                visited[x][y] = visited[i][j] + 1 ;
                
                if(x == curr_x && y == curr_y)
                    return visited[x][y] ;
                else
                    ue.add(new int[]{x , y} );
            }
        }
        
        return -1 ;
        
    }
}