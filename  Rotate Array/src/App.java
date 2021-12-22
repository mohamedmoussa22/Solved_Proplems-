import java.util.Arrays;

public class App {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public static void reverse(int arr[], int from, int to) {
        int numOfElements = (to - from) + 1;

        double timesOfloop = numOfElements % 2 == 0 ? numOfElements / 2 : Math.floor(numOfElements / 2);
        for (int i = 0; i < timesOfloop; i++) {
            swap(arr, from, to);
            from++;
            to--;
        }
    }

    public static void swap(int arr[], int indexFrom, int indexTo) {
        int temp = arr[indexFrom];
        arr[indexFrom] = arr[indexTo];
        arr[indexTo] = temp;
    }

    public static void main(String[] args) throws Exception {
       int [] inputArr = {1,2,3,4,5,6,7};
        rotate(inputArr, 3);
        System.out.println(Arrays.toString(inputArr));
    }
}
