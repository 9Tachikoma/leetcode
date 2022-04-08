/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            //两个if同时处理情况一和二
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //情况三的处理方式：用右子树最小节点替换root，转而删除右子树最小节点
            TreeNode minNode = getMin(root.right);
            root.right = deleteNode(root.right, minNode.val);
            minNode.right = root.right;
            minNode.left = root.left;
            root = minNode;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}