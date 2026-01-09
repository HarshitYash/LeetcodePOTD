public class Day1_090126_865_Smallest_Subtree_with_all_the_Deepest_Nodes {
    TreeNode res;
    int best;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        best = -1;
        dfs(root, 0);
        return res;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) return 0;

        int l = dfs(node.left , depth + 1);
        int r = dfs(node.right , depth + 1);

        int cur = l + depth;
        if (l == r && cur >= best) {
            best = cur;
            res = node;
        }

        return 1 + Math.max(l, r);
    }
}
