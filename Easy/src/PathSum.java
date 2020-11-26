/**
 * <p>
 *     Given a binary tree and a sum, determine if the tree has a root-to-leaf
 *     path such that adding up all the values along the path equals the given sum.
 * </p>
 */
public class PathSum {
    boolean found=true;
    static class Node{
        int value;
        Node left,right;
        Node(int value){
            this.value=value;
            left=right=null;
        }
    }

    /**
     * Runtime: 0ms, Space:38.7MB
     * @param root of tree
     * @param sum target sum
     * @return boolean true if target sum exists else false
     */
    public boolean hasPathSum(Node root, int sum){
        if (root==null) return false;
        dfsHelp(0,root,sum);
        return found;
    }

    public void dfsHelp(int curSum, Node root, int targetSum){
        if(root==null)
            return;
        curSum+=root.value;
        if(root.left==null && root.right==null && curSum==targetSum){
            found=true;
            return;
        }
        dfsHelp(curSum,root.left,targetSum);
        dfsHelp(curSum,root.right,targetSum);
    }

    public static void main(String[] args) {
        /**
         *           5
         *         /  \
         *        4    8
         *       /    / \
         *      11   13  4
         *     / \        \
         *    7   2        1
         */
        Node root=new Node(5);
        root.left=new Node(4);
        root.right=new Node(8);
        root.left.left=new Node(11);
        root.left.left.left=new Node(7);
        root.left.left.right=new Node(2);
        root.right.left=new Node(13);
        root.right.right=new Node(4);
        root.right.right.right=new Node(1);
        System.out.println(new PathSum().hasPathSum(root,22));
    }
}
