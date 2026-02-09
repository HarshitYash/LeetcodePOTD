public class Day32_090226_1382_Balance_a_Binary_Search_Tree {
    ArrayList<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return creation(0, list.size()-1);
    }
    public void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }
    public TreeNode creation(int start, int end){
        if(start > end) return null;
        int mid = start + (end-start)/2;
        TreeNode left = creation(start, mid-1);
        TreeNode right = creation(mid+1, end);
        return new TreeNode(list.get(mid), left, right);
    }
}
