public class App {
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
    }    public static void main(String[] args) throws Exception {
        int arr [] = {1 , 3 , 6 , 8 , 10};
        int index = binarySearch(arr , 10);
        System.out.println(index);
    }
}
