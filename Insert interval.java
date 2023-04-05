class Solution {
public int[][] insert(int[][] intervals, int[] newInterval) {

    List<int[]> intervalMap = new ArrayList<>();
    boolean flag = true;
    int j = 0;
    
    // add the newInterval at its correct position in the intervals array
    for(int i=0;i<intervals.length;i++){
        if(newInterval[0] <= intervals[i][0]){
            intervalMap.add(newInterval);
            flag = false;
            break;
        } else {
            intervalMap.add(intervals[i]);
        }
        j = i;
    }
    
	// add remaining intervals from intervals array into intervalMap list 
    for(int i = j; i < intervals.length; i++ ){
        intervalMap.add(intervals[i]);
    }
    
    
    // to confirm if the newInterval is already added or not.
    if(flag){
        intervalMap.add(newInterval);
    }
    
    
    // merge intervals
    List<int[]> resultList = new ArrayList<>();
    resultList.add(intervalMap.get(0));
    int k = 0;
    
    for(int i = 1; i<intervalMap.size();i++){
        
        if(intervalMap.get(i)[0] <= resultList.get(k)[1]){
            resultList.get(k)[1] = intervalMap.get(i)[1] <= resultList.get(k)[1] ? resultList.get(k)[1] : intervalMap.get(i)[1];
        } else {
            resultList.add(intervalMap.get(i));
            k++;
        }
        
    }
    
    return resultList.toArray(new int[resultList.size()][resultList.get(0).length]);
    
}
}