import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
     * Space complexity : O(log(N)) in the best case of completely balanced tree
     * and O(N) in the worst case of completely unbalanced tree, to keep a recursion stack
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

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        Queue<TreeNode> Q = new LinkedList<>();
        BFS(p, Q, l1);
        BFS(q, Q, l2);

        return l1.equals(l2);
    }

    /**
     * Comparing Breadth First Traversal of both trees
     * A Tree is typically traversed in two ways:
     *
     *      Breadth First Traversal (Or Level Order Traversal)
     *      Depth First Traversals
     *          Inorder Traversal (Left-Root-Right)
     *          Preorder Traversal (Root-Left-Right)
     *          Postorder Traversal (Left-Right-Root)
     * @param root root of tree
     * @param Q
     * @param list
     */
    public void BFS(TreeNode root, Queue<TreeNode> Q, List<Integer> list){
        //add node in queue
        Q.add(root);
        //add its value in list
        list.add(root.val);
        while(!Q.isEmpty()){
            TreeNode cur = Q.remove();

            if(cur.left != null){
                Q.add(cur.left);
                list.add(cur.left.val);
            }
            else list.add(null);

            if(cur.right != null){
                Q.add(cur.right);
                list.add(cur.right.val);
            }
            else list.add(null);
        }
    }
    public static void main(String[] args) {
        TreeNode root1=new TreeNode(1);
        TreeNode left1=new TreeNode(2);
        TreeNode right1=new TreeNode(3);
        root1.left=left1;
        root1.right=right1;

        TreeNode root2=new TreeNode(1);
        TreeNode left2=new TreeNode(2);
        TreeNode right2=new TreeNode(3);
        root2.left=left2;
        root2.right=right2;

        System.out.println(new SameTree().isSameTree(root1,root2));
        System.out.println(new SameTree().isSameTree2(root1,root2));
    }
}
