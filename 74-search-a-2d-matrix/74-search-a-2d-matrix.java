class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
               for (int i = 0 ; i < matrix.length; i++){
            if (binarySearch(matrix[i], 0, matrix[i].length - 1 , target) != -1){
               return true;
            }
        }
        return false;
    }
    
        public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (target < arr[mid]) {
            return binarySearch(arr, left, mid - 1, target);
        }
        return binarySearch(arr, mid + 1, right, target);
    }
}