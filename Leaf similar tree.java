    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        addLeaf(root1,list1);
        addLeaf(root2,list2);
        if(list1.size() != list2.size())
            return false;
        for(int i=0; i<list1.size(); ++i)
            if(list1.get(i) != list2.get(i))
                return false;
        return true;
    }
    
    private void addLeaf(TreeNode root,List<Integer> list){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        if(root.left != null)
            addLeaf(root.left,list);
        if(root.right != null)
            addLeaf(root.right,list);
    }