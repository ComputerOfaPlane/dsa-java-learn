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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                sb.append("#,");
                continue;
            }
            sb.append(node.val+",");
            if(node.left!=null) q.add(node.left);
            else q.add(null);
            if(node.right!=null) q.add(node.right);
            else q.add(null);
        }
        // System.out.println(sb);
        return new String(sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        Queue<StringBuilder> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int n = data.length();
        for(int i=0; i<n; i++){
            char ch = data.charAt(i);
            if(ch!=',') sb.append(ch);
            else{
                q.add(sb);
                sb = new StringBuilder();
            }
        }
        TreeNode root = new TreeNode(Integer.parseInt(new String(q.peek())));
        Queue<TreeNode> ans = new LinkedList<>();
        ans.add(root);
        q.poll();
        while(!q.isEmpty()){
            StringBuilder a = q.poll();
            StringBuilder b = q.poll();
            TreeNode node1, node2;
            if(a.charAt(0)=='#') node1 = null;
            else node1 = new TreeNode(Integer.parseInt(new String(a)));
            if(b.charAt(0)=='#') node2 = null;
            else node2 = new TreeNode(Integer.parseInt(new String(b)));
            ans.peek().left = node1;
            ans.peek().right = node2;
            ans.poll();
            if(node1!=null) ans.add(node1);
            if(node2!=null) ans.add(node2);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));