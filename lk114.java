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
    public void flatten(TreeNode root) {
        if(root == null) return;
        // 先递归拉平左右子树
        flatten(root.left);
        flatten(root.right);
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;
        //将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while(p.right!=null){
            p = p.right;//p目前指向最右端
        }
        p.right = right;//p的右指针指向原先的右子树，连接完成
    }
}