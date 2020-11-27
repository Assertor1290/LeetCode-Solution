import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
 *     Notice that the row index starts from 0.
 * </p>
 */
public class PascalsTriangleTwo {

    /**
     * Runtime: 0ms
     * @param rowIndex
     * @return List
     */
    public List getRow(int rowIndex){
        int[][] arr=new int[rowIndex+1][rowIndex+1];
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<=rowIndex;i++){
            for(int j=0;j<=i;j++){

                if(i==j || j==0){
                    arr[i][j]=1;
                    if(i==rowIndex)
                        list.add(1);
                }
                else{
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                    if(i==rowIndex)
                        list.add(arr[i][j]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int rowIndex=3;
        List list;
        list=new PascalsTriangleTwo().getRow(rowIndex);
        for (int i=0;i<=rowIndex;i++)
            System.out.print(list.get(i)+" ");

    }
}
