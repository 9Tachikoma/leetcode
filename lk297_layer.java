/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String SEP = ",";
    String NULL = "#";

    void traverse(TreeNode root){

        }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            /*层级遍历代码位置*/
            if (cur == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);

            q.offer(cur.left);
            q.offer(cur.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String [] nodes = data.split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        for(int i = 1;i< nodes.length;){
            TreeNode parent = q.poll();

            String left = nodes[i++];
            if(!left.equals(NULL)){
                parent.left = new TreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            }else {
                parent.left = null;
            }

            String right = nodes[i++];
            if(!right.equals(NULL)){
                parent.right = new TreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            }else {
                parent.right = null;
            }
        }
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));