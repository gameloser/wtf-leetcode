public class MaxPathSum124 {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxSum(root);
        return ans;
    }

//    int backtrack(TreeNode root) {
//        if (root == null) return 0;
//        int maxLeft = Math.max(backtrack(root.left), 0);
//        int maxRight = Math.max(backtrack(root.right), 0);
//        maxSum = Math.max(maxSum, root.val + maxLeft + maxRight);
//        return Math.max(maxLeft, maxRight) + root.val;
//    }

    int getMaxSum(TreeNode node) {
        if (node == null) return 0;
        int left = getMaxSum(node.left);  // 左子树的最大路径
        int right = getMaxSum(node.right);  // 右边子树的最大路径
        int pathSum = left + right + node.val; // 左子树最大路径+右子树最大路径+当前节点值
        ans = Math.max(pathSum, ans);  // 更新最大值

        // 要注意的是，返回值需要减去左子树和右子树较小的那一个，因为我们只需保留一边最大的，否则就不是一条路径了
        // 小于0则返回0，意味着没有任何最大路径大于0，因为会越加越小
//        return Math.max(pathSum - Math.min(left, right), 0);
        return Math.max(Math.max(left, right) + node.val, 0);
    }
}
