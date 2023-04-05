//Spiral matrix

class Solution {
   public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> result = new ArrayList<Integer>();
        int i=0;
        int j=0;
        int columnStart = 0;
        int lineStart = 0;
        int count =0;
        while(true){
            for(j=columnStart;j<m-lineStart;j++){
                result.add(matrix[lineStart][j]);
                count++;
            }
            if(count == m*n)
                return result;
            
            for(i=lineStart+1;i<n-lineStart;i++){
                result.add(matrix[i][m-columnStart-1]);
                count++;
            }
            if(count == m*n)
                return result;
            for(j=m-columnStart-2;j>columnStart;j--){
                result.add(matrix[n-lineStart-1][j]);
                count++;
            }
            columnStart++;
            lineStart++;
            if(count == m*n)
                return result;
            for(i=i-1;i>lineStart-1;i--){
                result.add(matrix[i][columnStart-1]);
                count++;
            }
            if(count == m*n)
                return result;
            
        }
    }
}