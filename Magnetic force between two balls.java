class Solution {
    public boolean valid(int[] arr, int m,int val){
        int ball=1;
        int prev=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-prev>=val){
                ball++;
                prev=arr[i];
            }
        }
        return ball>=m;
    }
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int lo=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            int d=arr[i+1]-arr[i];
            lo=Math.min(lo,d);
        }
        int ans=0;
        int hi=Math.max(arr[arr.length-1],arr[0]);
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(valid(arr,m,mid)){
                ans=mid;
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return ans;
    }
}