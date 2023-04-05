class Solution {
    public int maxPoints(int[][] points) {
        if(points.length == 1)
            return 1;
        int max = 0;
        for (int i = 0; i < points.length; i++){
            Map<Double, List<int[]>> map = new HashMap<>();
            for (int j = i+1; j < points.length; j++){
                int deltaX = points[i][0] - points[j][0];
                int deltaY = points[i][1] - points[j][1];
                Double slope;
                if (deltaX == 0){
                    slope = Math.pow(10, 8) + 10;
                }else{
                    if (deltaY == 0){
                        slope = 0.0;
                    }else{
                        slope = (1.0 * deltaY)/deltaX;
                    }
                }
                System.out.println(slope);
                // Inside the list, we store combination of two points that has certain slope.
                if (map.containsKey(slope)){
                    List<int[]> list = map.get(slope);
                    list.add(points[j]);
                    max = Math.max(max, list.size());
                }else{
                    List<int[]> list = new ArrayList<int[]>();
                    list.add(points[j]);
                    list.add(points[i]);
                    map.put(slope, list);
                    max = Math.max(max, list.size());
                }
                
            }
        }
        return max;
    }
}