/**
 * <p>
 *     Given a binary tree, find its maximum depth.
 *     The maximum depth is the number of nodes along the longest path
 *     from the root node down to the farthest leaf node.
 * </p>
 */
public class MaximumDepth {
    static class Node{
        int value;
        Node left,right;
        Node(int value){
            this.value=value;
            left=right=null;
        }
    }

    /**
     * TC:O(n) SC:O(n)
     * @param root of tree
     * @return maximum depth of tree
     */
    public int maximumDepth(Node root){
        return (root==null) ? 0: Math.max(maximumDepth(root.left),maximumDepth(root.right))+1;
    }
    public static void main(String[] args) {
        /**
         *      3
         *     / \
         *    9  20
         *       / \
         *      15  7
         *
         *  Max depth is 3
         */
        Node node=new Node(3);
        node.left=new Node(9);
        node.right=new Node(20);
        node.right.left=new Node(15);
        node.right.right=new Node(7);
        System.out.println(new MaximumDepth().maximumDepth(node));
    }
}
