import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums){
        int cntZeroes=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0)
                cntZeroes++;
        }

        int arr[]=new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                arr[j]=nums[i];
                j++;
            }
        }

        for (int i = 0; i < cntZeroes; i++) {
            arr[j]=0;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
    }
    public static void main(String[] args) {
        int[] nums=new int[]{0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
