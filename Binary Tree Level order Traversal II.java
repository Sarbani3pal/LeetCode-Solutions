//Binary Tree Level order Traversal II

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>(Collections.reverseOrder());
        traverse(root,0,map);
        final List<List<Integer>> ret=new ArrayList<>();
        map.forEach((k,v)->{
            ret.add(v);
        });
        return ret;
    }
    private void traverse(TreeNode node,int level,TreeMap<Integer,ArrayList<Integer>> map){
        if(node==null) return;
        if(!map.containsKey(level)){
            map.put(level,new ArrayList<>(Arrays.asList(node.val)));
        }else{
            ArrayList<Integer> list=map.get(level);
            list.add(node.val);
            map.put(level,list);
        }
        traverse(node.left,level+1,map);
        traverse(node.right,level+1,map);
    }
}