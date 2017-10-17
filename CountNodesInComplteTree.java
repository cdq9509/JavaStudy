/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
/* exceed time limit 
class Solution {
    
    public int countNodes(TreeNode root) {
      if ( root == null ) return 0;
      int sz = 1;
      sz += countNodes( root.left );
      sz += countNodes( root.right);
      return sz; 
    }
}
*/
import java.util.*;
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

/* Still timeline exceed 
class Solution {
  public int countNodes(TreeNode root) {
    if (root == null) return 0;
    
    int lH = 1; 
    TreeNode left = root.left; 
    while (left != null) {
      lH ++;
      left = left.left; 
    }
    
    int rH = 1; 
    TreeNode right = root.right; 
    while (right != null) {
      rH ++;
      right = right.right; 
    }
    
    if (lH == rH) { return ((int)Math.pow(2,lH)) - 1; }
    
    return countNodes(root.left) + countNodes(root.right) + 1; 
    
  }
}
*/

/** I think the below solution is actually clean enough. But it still exceed timeline. 
turns out that I just need to replace Maht.pow with 1 <<  and that solve the problem.
apparently, math.pow is slow. 
*/
class Solution {
  
  // find max depth of complte binary tree.
  public int findLeftDepth(TreeNode root) {
    int maxH = 0;
    TreeNode curRoot = root; 
    while (curRoot != null) {
      curRoot = curRoot.left; 
      maxH++; 
    }
    return maxH; 
  }

  public int countNodesHelper(TreeNode root, int maxH) {
      int retH = 0;
      if (root == null) return 0; 
      if (root.left == null && root.right == null) return 1;
      if (root.left != null && root.right == null) return 2; // this is split
      
      if (findLeftDepth(root.right) < maxH - 1) {
        retH += ((int) Math.pow(2, maxH-2)) - 1; // right must have height of maxH-2
        retH += countNodesHelper(root.left, maxH - 1 ); // left have up to maxH - 1
        retH += 1; // add root
      } else {
        retH += ((int) Math.pow(2,maxH-1)) - 1; // left must have height of maxH - 1
        retH += countNodesHelper(root.right, maxH - 1 ); // right also have up to maxH - 1         
        retH += 1; // add root
      }
      return retH; 
  }
  
  
  public int countNodes(TreeNode root) {    
    // Height of the tree. Note that the first node that does not have this depth is the split. 
    int h = findLeftDepth(root);
    return countNodesHelper(root, h);    
  }
}

class Tester {
  
  public static void main(String [] args) 
  {
    Solution sol = new Solution();
  }
}

