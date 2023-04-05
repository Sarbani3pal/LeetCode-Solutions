class Solution {
    public int countNodes(TreeNode root) {
        if(null == root) return 0;
        int count = 0;
        Queue<NodeInfo> q = new LinkedList<>();
        q.add(new NodeInfo(root, 0));
        while(!q.isEmpty()){
            NodeInfo info = q.poll();
            TreeNode curr = info.node;
            int level = info.level;
            if(curr.left == null && curr.right!=null) continue;
            
            if(curr.left != null)
                q.add(new NodeInfo(curr.left, level+1));
            
            if(curr.right != null)
                q.add(new NodeInfo(curr.right, level+1));
            
            ++count;
        }
        
        return count;
    }
}

class NodeInfo{
    TreeNode node;
    int level;
    
    public NodeInfo(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}