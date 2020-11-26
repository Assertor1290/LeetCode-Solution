import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 *     Given a binary tree, find its minimum depth.
 *     The minimum depth is the number of nodes along the shortest path
 *     from the root node down to the nearest leaf node.
 * </p>
 */
public class MinimumDepth {
    static class Node{
        int value;
        Node left,right;
        Node(int value){
            this.value=value;
            left=right=null;
        }
    }

    public int minDepth(Node root){
        if(root==null) return 0;
        //use queue to keep track of tree
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        int depth=0;
        //solving it using BFS
        while(!queue.isEmpty()){
            //Increment depth by 1
            depth++;;
            //size represents number of nodes at that depth.
            //eg: For root node it is 1
            int size=queue.size();
            //process all nodes at same level
            for(int i=0;i<size;i++){
                Node node=queue.remove();
                //If it is a leaf node, return depth
                if(node.left==null && node.right==null)
                    return depth;
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        /**
         *      3
         *     / \
         *    9  20
         *       / \
         *      15  7
         */
        Node root=new Node(3);
        root.left=new Node(9);
        root.right=new Node(20);
        root.right.left=new Node(15);
        root.right.right=new Node(7);
        System.out.println(new MinimumDepth().minDepth(root));
    }
}
