class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check rows and columns first
        for (int i = 0; i < board.length; i++) {
            // set stores only unique elements
            Set<Character> rowSet = new HashSet<Character>();
            Set<Character> colSet = new HashSet<Character>();
            
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.' && board[j][i] == '.') {
                    continue;
                }
                if ((board[i][j] != '.' && !rowSet.add(board[i][j])) || (board[j][i] != '.' && !colSet.add(board[j][i]))) {
                    return false;
                };
            }            
        }
        
        // check 3x3 sub-boxes
		for (int k = 0; k < board.length; k++) {
			Set<Character> boxSet = new HashSet<Character>();
			for (int i = (k/3)*3; i < (k/3)*3 + 3; i++) {
				for (int j = (k%3)*3; j < (k%3)*3 + 3; j++) {
					if (board[i][j] != '.' && !boxSet.add(board[i][j])) {
						return false;
					}
				}   
			}
		}
        return true;
    }
}