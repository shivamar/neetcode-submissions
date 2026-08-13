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

    int diameter=0;

    public int diameterOfBinaryTree(TreeNode root) {  
        this.diameter=0;
        int ht = height(root); 
       // System.out.println(ht + "  "+ diameter);
       // return Math.max(diameter, ht-1);

        return diameter;
    }

    public int height(TreeNode root) {
        if(root==null) return 0;

        int leftHt =  height(root.left);
        int rightHt = height(root.right);
        this.diameter = Math.max(diameter, leftHt+rightHt);
        System.out.println(root.val + " -- "+ (Math.max(leftHt, rightHt)+1));
        return 1 + Math.max(leftHt, rightHt);
    }
}
