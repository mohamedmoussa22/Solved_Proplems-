public class App {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complimant = Math.abs(target - nums[i]);
            if (map.containsKey(complimant)) {
                return new int[] { map.get(complimant), i };

            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("NO match Found");
    }

}
