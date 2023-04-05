class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        } else {
            addOneRow(root, val, depth, 1);

            return root;
        }
    }

    private void addOneRow(TreeNode curNode, int val, int targetDepth, int curDepth) {
        if (curNode == null) return;
        if (curDepth + 1 == targetDepth) {
            curNode.left = new TreeNode(val, curNode.left, null);
            curNode.right = new TreeNode(val, null, curNode.right);
        } else {
            addOneRow(curNode.left, val, targetDepth, curDepth + 1);
            addOneRow(curNode.right, val, targetDepth, curDepth + 1);
        }
    }
}