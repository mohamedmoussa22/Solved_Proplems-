class Solution {
    public int maxSubArray(int[] nums) {
             	int golobalMax = nums[0], currentMax = nums[0];
		for (int i = 1; i < nums.length; i++) {

			currentMax = Math.max(nums[i], currentMax + nums[i]);
			golobalMax = Math.max(currentMax, golobalMax);
		}

		return golobalMax;
    }
}