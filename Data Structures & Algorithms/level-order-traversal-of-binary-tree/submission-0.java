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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<> ();
      if(root==null) return result;

      ArrayDeque<TreeNode> arrayDeq = new ArrayDeque<>();
      arrayDeq.offer(root);

      while(!arrayDeq.isEmpty())
      {
        int size = arrayDeq.size();
        List<Integer> arrayLi = new ArrayList<Integer>();
        for(int i=0;i< size;i++){
          TreeNode curr = arrayDeq.poll();
          arrayLi.add(curr.val);

          if(curr.left!=null) arrayDeq.offer(curr.left);
          if(curr.right!=null) arrayDeq.offer(curr.right);
        }
    
        if(arrayLi.size() > 0)
         result.add(arrayLi);
      }

    return result;
    }
}
