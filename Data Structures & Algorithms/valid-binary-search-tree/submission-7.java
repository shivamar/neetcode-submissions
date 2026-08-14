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

    public boolean isValidBST(TreeNode root) {

      return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean validate(TreeNode root, int lowerBound, int upperBound){
       if(root==null) return true;
     // System.out.println(lowerBound + "  "+ upperBound);

        if(root.val <= lowerBound || root.val >= upperBound) return false;
        if(!validate(root.left, lowerBound, Math.min(root.val, upperBound))) return false;
        if(!validate(root.right, Math.max(root.val, lowerBound), upperBound )) return false;

     return true; 
  }
}
