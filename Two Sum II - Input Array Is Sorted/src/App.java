import java.util.Arrays;

public class App {
    public static int[] twoSum(int[] numbers, int target) {
        int size = numbers.length , index ;
        int outPut[]  = {0,0};  

         for (int i = 0 ; i < size ;i++ ){
             index =  binarySearch(numbers , target - numbers[i]);
            if ( index != -1  && index != i  ){
                outPut[0]= Math.min(i, index) + 1 ;
                outPut[1]= Math.max(i, index) + 1; 
                break;
            }
         }
         return outPut;
    }
        public static int binarySearch(int[] nums, int target) {
        int firstIndex = 0;
        int lastIndex = nums.length - 1;
        int mid = 0;
        while (firstIndex <= lastIndex) {
            mid = (firstIndex + lastIndex) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                lastIndex = mid 
                - 1;
            } else {
                firstIndex = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
       int inputArr[] ={2,7,11,15};
       int [] indexes = twoSum(inputArr, 9);
       System.out.println(Arrays.toString(indexes));
    }
}
