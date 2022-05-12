public class binarySearch {

    public static int binarySearch1(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (target < arr[mid]) {
            return binarySearch1(arr, left, mid - 1, target);
        }
        return binarySearch1(arr, mid + 1, right, target);
    }
}
