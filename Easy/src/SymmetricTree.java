import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    static class Node{
        int value;
        Node left,right;
        Node(int value){
            this.value=value;
            left=right=null;
        }
    }

    /**
     * Runtime: 0ms
     * TC:O(n)
     * SC:O(n)
     * @param root root of tree
     * @return true if symmetric else false
     */
    public boolean isSymmetric(Node root){
        //passing two roots. One will traverse left subtree
        //and other will traverse right subtree.
        return isMirror(root,root);
    }
    private boolean isMirror(Node p, Node q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.value!= q.value) return false;
        return isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }

    /**
     * Runtime:1ms
     * TC: O(n)
     * SC: O(n)
     * @param root root of tree
     * @return true if symmetric else false
     */
    public boolean isSymmetric2(Node root){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            Node p=queue.poll();
            Node q=queue.poll();
            if(p==null && q==null) continue;
            if(p==null || q==null) return false;
            if(p.value!=q.value) return false;
            queue.add(p.left);
            queue.add(q.right);
            queue.add(p.right);
            queue.add(q.left);
        }
        return true;
    }

    public static void main(String[] args) {

        /**
         *       1
         *     /  \
         *    2    2
         *   / \  / \
         *  3  4 4   3
         */
        Node root1=new Node(1);
        root1.left=new Node(2);
        root1.left.left=new Node(3);
        root1.left.right=new Node(4);
        root1.right=new Node(2);
        root1.right.left=new Node(4);
        root1.right.right=new Node(3);
        System.out.println(new SymmetricTree().isSymmetric(root1));
        System.out.println(new SymmetricTree().isSymmetric2(root1));
    }
}
