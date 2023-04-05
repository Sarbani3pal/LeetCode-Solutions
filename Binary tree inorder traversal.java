class Solution {
private List al = new ArrayList();
public List inorderTraversal(TreeNode root) {
if(root==null)return al;
inorderTraversal(root.left);
al.add(root.val);
inorderTraversal(root.right);
return al;
}
}