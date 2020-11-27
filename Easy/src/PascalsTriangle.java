import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *                  1
 *                1  1
 *              1  2  1
 *            1  3  3  1
 *          1  4  6  4  1
 *     In Pascal's triangle, each number is the sum of the two numbers directly above it
 * </p>
 */
public class PascalsTriangle {
    /**
     * Visualize triangle as follows:
     *         [0] [1] [2] [3] [4]
     *  [0]     1
     *  [1]     1   1
     *  [2]     1   2   1
     *  [3]     1   3   3   1
     *  [4]     1   4   6   4   1
     */
    public List<List<Integer>> generate(int n){
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    list.get(i).add(1);
                }
                else{
                    list.get(i).add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int n=5;
        List<List<Integer>> list=new ArrayList<>();
        list= new PascalsTriangle().generate(n);
        for(int i=0;i<n;i++)
            System.out.println(list.get(i));
    }
}
