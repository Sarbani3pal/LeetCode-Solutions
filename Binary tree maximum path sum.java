class Solution {
	public int maxPathSum(TreeNode root) {
		Integer[] result = new Integer[]{Integer.MIN_VALUE};
		dfs(root,result);
		return result[0];
	}

	public int dfs(TreeNode root,Integer[] result){
		if(root==null) return 0;
		int left = dfs(root.left,result);
		int right = dfs(root.right,result);
		int count = root.val;
		count = Math.max(count,root.val+left);
		count = Math.max(count,root.val+right);
		count = Math.max(count,root.val+left+right);
		if(count>result[0]) result[0] = count;
		return Math.max(root.val,Math.max(root.val+right,root.val+left));
	}
}