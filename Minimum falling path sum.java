class Solution {
      public int minFallingPathSum(int[][] A) {
        int n = A.length;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int minOfAbove3 = A[i - 1][j];
                if (j > 0 && A[i - 1][j - 1] < minOfAbove3) { minOfAbove3 = A[i - 1][j - 1]; }
                if (j + 1 < n && A[i - 1][j + 1] < minOfAbove3) { minOfAbove3 = A[i - 1][j + 1]; }
                A[i][j] += minOfAbove3;            
            }
        }
        return  Arrays.stream(A[n - 1]).min().getAsInt();
    }
}