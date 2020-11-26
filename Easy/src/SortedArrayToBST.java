/**
 * <p>
 *     Given an array where elements are sorted in ascending order,
 *     convert it to a height balanced BST.
 *     For this problem, a height-balanced binary tree is defined as a
 *     binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * </p>
 */
public class SortedArrayToBST {
    static class Node{
        int val;
        Node left,right;
        Node(int val){
            this.val=val;
            left=right=null;
        }
    }

    /**
     * TC: O(n)
     * @param nums sorted input array
     * @return root of tree
     */
    public Node sortedArrayToBST(int[] nums){
        if(nums.length==0)
            return null;
        return buildTree(nums,0, nums.length-1);
    }

    private Node buildTree(int[] nums, int start, int end){
        //Base case
        if(start>end) return null;
        //Get middle element and make it root
        int mid=(start+(end-start)/2);
        //Mid node forms root
        Node root=new Node(nums[mid]);
        //recursively construct left subtree and make it left child of root
        root.left=buildTree(nums,start,mid-1);
        //recursively construct right subtree and make it right child of root
        root.right=buildTree(nums,mid+1,end);
        return root;
    }

    private void preorder(Node root){
        if(root==null)
            return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        /**
         *          4
         *         / \
         *        2   6
         *       / \ / \
         *      1  3 5  7
         */
        int[] arr=new int[]{1,2,3,4,5,6,7};
        SortedArrayToBST sortedArrayToBST=new SortedArrayToBST();
        Node trav=sortedArrayToBST.sortedArrayToBST(arr);
        sortedArrayToBST.preorder(trav);
    }
}
