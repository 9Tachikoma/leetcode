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
    HashMap<String, Integer> memo = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    String traverse(TreeNode root){
        if(root == null){
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;
        //计算子树的出现次数，找到就获得，找不到就为0
        int freq = memo.getOrDefault(subTree,0);

        //在res里只加入出现次数为1的子树
        if(freq == 1){
            res.add(root);
        }
        //添加子树进hashmap,并给子树对应的出现次数加一
        memo.put(subTree, freq + 1);
        return subTree;
    }
}