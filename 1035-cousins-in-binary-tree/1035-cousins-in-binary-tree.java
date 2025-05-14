/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            boolean foundX = false, foundY = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.val == x) foundX = true;
                if (node.val == y) foundY = true;

                if (node.left != null && node.right != null) {
                    int leftVal = node.left.val;
                    int rightVal = node.right.val;
                    if ((leftVal == x && rightVal == y) || (leftVal == y && rightVal == x)) {
                        return false; // siblings, not cousins
                    }
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (foundX && foundY) return true;   // found at same level, not siblings
            if (foundX || foundY) return false;  // one found without the other
        }

        return false;
    }
}
