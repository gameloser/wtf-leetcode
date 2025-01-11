package Trees;

public class FlattenTreeNode {
//    TreeNode pre = new TreeNode(-1);
//    TreeNode p = pre;
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        traverse(root);
//        root.left = null;
//        root.right = pre.right.right;
//    }
//
//    public void traverse(TreeNode root) {
//        if (root == null) return;
//        p.right = new TreeNode(root.val);
//        p = p.right;
//        traverse(root.left);
//        traverse(root.right);
//    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        if (root.left != null && root.right != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            TreeNode p = root.right;
            while (p.right != null) {
                p = p.right;
            }
            p.right = temp;
            root.left = null;
        } else if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
        } else if (root.left == null && root.right != null) {
            //
        } else {
            //
        }
    }

}
