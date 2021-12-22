
import java.util.Arrays;

public class App {


    public static void swap (int arr[] , int indexFrom ,int indexTo ){
        int temp = arr[indexFrom];
        arr[indexFrom] = arr[indexTo];
        arr[indexTo] = temp;
    }
    public static void moveZeroes(int[] nums) {
        int leftPointer = 0 , rightPointer = 0 , size = nums.length;
   while (leftPointer  < size  && rightPointer < size ){
         if (nums[rightPointer] != 0){
                  swap(nums, rightPointer, leftPointer);
                  rightPointer++ ;
                  leftPointer++;
         }
         else  {
             rightPointer++;
         }
   } 
}

    public static void main(String[] args) throws Exception {
        int inputArr [] = {0,1,0,3,12};
        moveZeroes(inputArr);
        System.out.println(Arrays.toString(inputArr));
    }
}
