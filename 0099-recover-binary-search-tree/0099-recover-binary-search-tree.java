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
  public void recoverTree(TreeNode root) {
    inorder(root);
    swap(x, y);
  }

  private TreeNode pred = null;
  private TreeNode x = null; // the first wrong node
  private TreeNode y = null; // the second wrong node

  private void inorder(TreeNode root) {
    if (root == null)
      return;

    inorder(root.left);

    if (pred != null && root.val < pred.val) {
      y = root;
      if (x == null)
        x = pred;
      else
        return;
    }
    pred = root;

    inorder(root.right);
  }

  private void swap(TreeNode x, TreeNode y) {
    final int temp = x.val;
    x.val = y.val;
    y.val = temp;
  }
}