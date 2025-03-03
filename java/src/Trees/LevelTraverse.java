package Trees;

import java.util.*;

class LevelTraverse {


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = size; i > 0; i--) {
                TreeNode node = q.poll();
                if (node == null) continue;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                l.add(node.val);
            }
            res.add(l);
        }
        return res;
    }

/*    DFS
    private Map<Integer, List<Integer>> map = new HashMap<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        traverse(root, 0);
        return new ArrayList<>(map.values());
    }
    public void traverse(TreeNode root, int level) {
        if (root == null) return;
        if (map.get(level) == null) {
            map.put(level, new ArrayList<Integer>());
        }
        map.get(level).add(root.val);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }*/
}
