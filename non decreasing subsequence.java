class Solution {

    public Solution() {}

    int[] nums;
    List<List<Integer>> globalResult;
    int[] currentList;
    int currentListLength;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        this.currentList = new int[nums.length+1];
        globalResult = new ArrayList<>();
        backtrack(0, -1);

        return globalResult;
    }

    public void backtrack(int i, int l ) {
        if (i >= nums.length) {
            if (currentListLength >= 2) {
                var result = new ArrayList<Integer>(currentListLength);
                for(int j = 0; j < currentListLength; j++)
                    result.add(currentList[j]);
                globalResult.add(result);
            }
            return;
        }
        if (l == -1 || nums[i] >= nums[l]) {
            currentList[currentListLength++] = nums[i];
            backtrack(i+1, i);
            currentListLength--;
        }
        if ((l == -1) || (nums[i] != nums[l]))
            backtrack(i+1, l); // backtrack excluding current number
    }
}