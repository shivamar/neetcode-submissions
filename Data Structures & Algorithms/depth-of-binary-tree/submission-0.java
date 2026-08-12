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

   class TreeNodeWithD {
        TreeNode treeNode;
        int depth;
    }

    public int maxDepth(TreeNode root) {

        if(root==null) return 0;

        ArrayDeque<TreeNodeWithD> stack = new ArrayDeque<TreeNodeWithD>();

        TreeNodeWithD treeNodeWithD = new TreeNodeWithD();
        treeNodeWithD.treeNode=root;
        treeNodeWithD.depth=1;

        stack.push(treeNodeWithD);
        int maxDepth=1;
        TreeNodeWithD nextTreeNodeWithD = null;

        while(!stack.isEmpty()){
            treeNodeWithD = stack.pop();
            TreeNode currNode = treeNodeWithD.treeNode;
            maxDepth=Math.max(treeNodeWithD.depth, maxDepth);

            if(currNode.left != null){
                nextTreeNodeWithD = new TreeNodeWithD();
                nextTreeNodeWithD.treeNode = currNode.left;
                nextTreeNodeWithD.depth = treeNodeWithD.depth+1;

                stack.push(nextTreeNodeWithD);
            }
            if(currNode.right != null){
                nextTreeNodeWithD = new TreeNodeWithD();
                nextTreeNodeWithD.treeNode = currNode.right;
                nextTreeNodeWithD.depth = treeNodeWithD.depth+1;

                stack.push(nextTreeNodeWithD); 
            }
        }

        return maxDepth;


    }
}