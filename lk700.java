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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }

        if(root.val > val){
            return searchBST(root.left,val);
        }

        if(root.val < val){
            return searchBST(root.right,val);
        }
        return root;
    }
}
//    TreeNode searchBST(TreeNode root, int target);
//    if (root == null) return null;
//            if (root.val == target) return root;
//            // 当前节点没找到就递归地去左右子树寻找
//            TreeNode left = searchBST(root.left, target);
//            TreeNode right = searchBST(root.right, target);
//
//            return left != null ? left : right;
//            }
//在普通树中寻找