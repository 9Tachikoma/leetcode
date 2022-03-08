public class lk104 {
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
        // 记录最大深度
        int res = 0;
        // 记录遍历到的节点的深度
        int depth = 0;

        // 主函数
        int maxDepth(TreeNode root) {
            traverse(root);
            return res;
        }

        // 二叉树遍历框架
        void traverse(TreeNode root) {
            if (root == null) {
                // 到达叶子节点，更新最大深度
                res = Math.max(res, depth);
                return;
            }
            // 前序位置
            depth++;
            traverse(root.left);
            traverse(root.right);
            // 后序位置
            depth--;
        }
    }
}
