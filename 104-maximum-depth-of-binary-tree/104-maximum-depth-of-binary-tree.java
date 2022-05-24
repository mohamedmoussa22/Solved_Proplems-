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
    public int maxDepth(TreeNode root) {
           if (root == null ){
                return 0 ;
            }
             return maxDepthRecrsive(root , 1);   
    }
    
             public static int maxDepthRecrsive(TreeNode root , int maxPath) {
                    if (root == null ) return maxPath;
             if (root.right == null && root.left == null ){
                return maxPath;
             }
             
       return  Math.max(maxDepthRecrsive(root.left, maxPath + 1), maxDepthRecrsive(root.right, maxPath + 1 ));
     }
}