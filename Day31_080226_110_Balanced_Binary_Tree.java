public class Day31_080226_110_Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    public int height(TreeNode node){
        if(node == null) return 0;

        int leftH = height(node.left);
        if(leftH == -1) return -1;

        int rightH = height(node.right);
        if(rightH == -1) return -1;

        if(Math.abs(leftH - rightH) > 1) return -1;

        return Math.max(leftH, rightH)+1;
    }
}
