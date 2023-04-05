//Transport matrix

class Solution {
    public int[][] transpose(int[][] A) {
        //if we have a non square matrix, we cannot simply do in-place swapping because it will be index out of bound
        //so we have to make a new MxN matrix if the input matrix is NxM where N != M
        int numRows = A.length;
        int numCols = A[0].length;
        
        if(numRows != numCols){
            int[][] transMatrix = new int[numCols][numRows];
            int i = 0;
            for(int[] row : A){
                for(int j=0;j<numCols;j++){
                    transMatrix[j][i] = row[j];
                }
                i++;
             }
            return transMatrix;
            // if it is a square matrix, we can simply do in-place flipping to save space..
        } else {
             for(int i=0;i<numRows;i++){
                for(int j=1+i;j<numCols;j++){
                    int temp = A[i][j];
                    A[i][j] = A[j][i];
                    A[j][i] = temp;
                }
            }
            return A;
        }
    }
}