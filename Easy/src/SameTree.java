/**
 * <p>
 *     Given two binary trees, write a function to check if they are the same or not.
 *     Two binary trees are considered the same if they are structurally identical and
 *     the nodes have the same value.
 * </p>
 */
public class SameTree {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    /**
     * Recursive solution
     * Time complexity : O(N), where N is the number of nodes in the tree,
     * since one visits each node exactly once.
     * Space complexity : O(log(N)) in the best case of completely balanced tree and \mathcal{O}(N)O(N) in the worst case of completely unbalanced tree, to keep a recursion stack
     * @param p root node of first tree
     * @param q root node of second tree
     * @return boolean if trees are same or not
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        if(p.val!=q.val)
            return false;
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
    public static void main(String[] args) {

    }
}
