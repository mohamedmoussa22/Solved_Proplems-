public class maxArea {
    public static int maxAreaa(int[] height) {

        int maxArea = 0, firstIndexPointer = 0, lastIndexPointer = height.length - 1;

        while (firstIndexPointer < lastIndexPointer) {
            if (height[firstIndexPointer] < height[lastIndexPointer]) {
                maxArea = Math.max(maxArea, height[firstIndexPointer] * (lastIndexPointer - firstIndexPointer));
                firstIndexPointer++;

            } else {
                maxArea = Math.max(maxArea, height[lastIndexPointer] * (lastIndexPointer - firstIndexPointer));
                lastIndexPointer--;
            }

        }
        return maxArea;
    }
}
