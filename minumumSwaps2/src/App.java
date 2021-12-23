import java.util.Arrays;

public class App {
    
    public static int minimumSwaps(int[] arr) {
        int size = arr.length , numberOfSwaps = 0 ;
       for (int i =0 ; i < size -1 ; i ++){
              if ( arr[i] != i + 1){
                   int temp = arr[arr[i] - 1 ];
                   arr[arr[i] - 1 ] = arr[i];
                   arr[i] = temp;
                   numberOfSwaps++;
                   i--;
              }

       }
       return numberOfSwaps;

    }
    public static void main(String[] args) throws Exception {
        int arr []  = {2,3 ,4, 1, 5};
        int number = minimumSwaps(arr);
         System.out.println(number);
         System.out.println(Arrays.toString(arr));
    }
}
