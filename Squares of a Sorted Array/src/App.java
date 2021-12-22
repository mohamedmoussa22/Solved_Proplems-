import java.sql.Array;
import java.util.Arrays;

public class App {
    public static int[] sortedSquares(int[] nums) {
        int left  = 0 , size = nums.length , right= size - 1 , index = size -1 ;
           int [] outPut = new int [size];
  
           while ( left <= right ){
                    if (Math.abs(nums[left]) < Math.abs(nums[right])){
                      outPut[index] = nums[right] * nums[right];
                      index--;      
                      right --;
                    } 
                    else {
                      outPut[index] = nums[left] * nums[left];
                      index--; 
                      left ++;
                    }
           }
           return outPut ; 
      }
    public static void main(String[] args) throws Exception {
        int arr [] = {-10 , 5 , 25 , 50};
        int outPut[] = sortedSquares(arr);
        System.out.println(Arrays.toString(outPut));
    }
}
