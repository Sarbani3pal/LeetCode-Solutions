class Solution {
    private void levelOrderRec(TreeNode root, int level, List<List<Integer>> res){
        if(root == null){
            return;
        }
        
        if(res.size() == level){
            res.add(new LinkedList<>());
        }
        
        res.get(level).add(root.val);
        levelOrderRec(root.left, level+1, res);         
        levelOrderRec(root.right, level+1, res);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderRec(root, 0, res);
        return res;
    }
}