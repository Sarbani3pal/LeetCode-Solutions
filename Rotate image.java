class Solution {
public void rotate(int[][] arr) {
int len = arr.length,temp;
for(int i=0;i<len;i++){
for(int j=i;j<len;j++){
temp = arr[i][j];
arr[i][j] = arr[j][i];
arr[j][i] = temp;
}
}

    for(int i=0;i<len;i++){
        for(int j=0;j<len/2;j++){
            temp = arr[i][j];
            arr[i][j] = arr[i][len-j-1];
            arr[i][len-j-1] = temp;
        }
    }        
}
}