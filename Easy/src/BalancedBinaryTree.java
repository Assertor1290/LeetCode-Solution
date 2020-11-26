/**
 * <p>
 *     Given a binary tree, determine if it is height-balanced.
 *     For this problem, a height-balanced binary tree is defined as:
 *     a binary tree in which the left and right subtrees of every node
 *     differ in height by no more than 1.
 * </p>
 */
public class BalancedBinaryTree {
    boolean c=true;
    static class Node{
        int value;
        Node left,right;
        Node(int value){
            this.value=value;
            left=right=null;
        }
    }

    /**
     * TC: O(n)
     * @param root of tree
     * @return boolean true if tree is balanced else false
     */
    public boolean isBalanced(Node root){
        int i= check(root);
        return c;
    }
    //Function will ch
    public int check(Node root){
        if(root==null)
            return 0;
        int leftHeight=check(root.left);
        int rightHeight=check(root.right);

        if(Math.abs(leftHeight-rightHeight)>1)
           c=false;

        return 1+Math.max(leftHeight,rightHeight);
    }

    public static void main(String[] args) {
        /**
         *           3
         *         /  \
         *        9   20
         *            / \
         *           15  7
         */
        Node root=new Node(3);
        root.left=new Node(9);
        root.right=new Node(9);
        root.right.left=new Node(15);
        root.right.right=new Node(7);
        System.out.println(new BalancedBinaryTree().isBalanced(root));
    }
}
