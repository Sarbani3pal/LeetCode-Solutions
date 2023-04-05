//Combination sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>() ;
		List<Integer> ds = new ArrayList<>() ;
		helper(candidates,0,target,ds,ans);
		return ans ;
    }
	
	
	static void helper(int[] candidates,int index, int target, List<Integer> ds,List<List<Integer>> ans ) {
        
//         we are doing recursion till end of the array thats why index == candidates.length
		if(index==candidates.length ) {
			if(target==0) {
				ans.add(new ArrayList<>(ds));
			}
			return ;
		}
        
        
// 		after substracting  element of last recursion call odf candidates array check for value of target
		if(target<0) {
			return ;
		}
        
//         2 possibilities either we are tsking that elemnt OR
			if(candidates[index]<=target ) {
				ds.add(candidates[index]);
				helper(candidates,index,target-candidates[index],ds,ans);
				ds.remove(ds.size()-1);
			}
//         OR we are ignoring it
			helper(candidates,index+1,target,ds,ans);
	}
      
}