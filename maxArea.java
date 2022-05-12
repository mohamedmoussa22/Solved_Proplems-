public class maxArea {
    public static int maxAreaa(int[] height) {

        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int x = height[i], y = height[j];
                int calcArea = Math.min(x, y) * (j - i);
                if (calcArea > maxArea) {
                    maxArea = calcArea;
                }
            }

        }
        return maxArea;

    }
}
