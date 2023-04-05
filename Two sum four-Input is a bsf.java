class Solution {
   public void traversal(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        traversal(root.left, arr);
        arr.add(root.val);
        traversal(root.right, arr);
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        traversal(root, arr);

        int i = 0, j = arr.size() - 1;

        while (i < j) {
            int sum = arr.get(i) + arr.get(j);
            if (sum == k) {
                return true;
            }
            if (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}