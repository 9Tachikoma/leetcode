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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    void serialize(TreeNode root,StringBuilder sb) {
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }

        serialize(root.left,sb);
        serialize(root.right,sb);
        sb.append(root.val).append(SEP);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEP)){
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    TreeNode deserialize(LinkedList<String> nodes) {
        if(nodes.isEmpty()) return null;
        String last = nodes.removeLast();
        if(last.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));

        // 因为是后序，先构造右子树，后构造左子树
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));