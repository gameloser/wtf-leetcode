package Trees;



class DiameterOfBinaryTree {
    int maxDia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        maxDepth(root);
        return maxDia;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxDia = Math.max(maxDia, left + right);
        return Math.max(left, right) + 1;
    }
}
