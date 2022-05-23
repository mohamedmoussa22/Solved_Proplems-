class Solution {
    public int minEatingSpeed(int[] piles, int h) {


        int rightPointer = getMaximum(piles), leftPointer = 1, mid = 0, minSpeed = Integer.MAX_VALUE;

        while (leftPointer <= rightPointer) {
            mid = (rightPointer + leftPointer) / 2;
            int holder = 0;
            for (int j = 0; j < piles.length; j++) {
                holder += (piles[j] / mid) + (piles[j] % mid == 0 ? 0 : 1);
            }
            if (holder <= h) {
                minSpeed = Math.min(minSpeed, mid);
                rightPointer = mid - 1;
            }

            else {
                leftPointer = mid + 1;
            }
        }

        return minSpeed;
    }
           public static int getMaximum (int arr[] ){
             int max = 0 ; 
             for (int i =0 ; i < arr.length ;i++){
                 if (arr[i] > max){
                     max = arr[i];
                 }
             }
             return max ;
       }
}