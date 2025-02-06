package Algorithm.search;

import Trees.TreeNode;

public class DFS {
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
//        System.out.println(dfs.dfs());
    }
}
