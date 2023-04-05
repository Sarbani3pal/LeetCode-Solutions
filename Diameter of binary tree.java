//Diameter of binary tree

class Solution {
    public int res = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        
        solve(root);
        
        return res-1;
    }
    public int solve(TreeNode root)
    {
        if(root ==null)
            return 0;
        
        int left = solve(root.left);
        int right = solve(root.right);
        
        int temp = Math.max(left,right)+1;
        int ans = Math.max(temp,1+left+right);
        
        res = Math.max(res,ans);
        
        return temp;
    }
}