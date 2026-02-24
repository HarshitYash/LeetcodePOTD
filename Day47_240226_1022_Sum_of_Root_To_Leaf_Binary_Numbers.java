public class Day47_240226_1022_Sum_of_Root_To_Leaf_Binary_Numbers {
    public int sumRootToLeaf(TreeNode root) {
        return check(root, "");
    }
    public int check(TreeNode node, String s){
        if(node == null) return 0;

        if(node.left == null && node.right == null){
            return Integer.valueOf(s + node.val, 2);
        }
        return check(node.left, s + node.val) + check(node.right, s + node.val);
    }
}
