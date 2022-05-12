public class NextPermutation {
    public static void swapIntArray(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;

    }

    public static void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int rightPointer = nums.length - 1;
        int leftPointer = nums.length - 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[rightPointer] > nums[leftPointer]) {
                swapIntArray(nums, rightPointer, leftPointer);
                return;
            }
            if (leftPointer > 0) {
                rightPointer--;
                leftPointer--;
            }

        }

        Arrays.sort(nums);
    }
}
