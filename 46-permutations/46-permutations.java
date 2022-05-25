class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> ans = new LinkedList<>();
        List<Integer> current = new LinkedList<>();
        boolean used[] = new boolean[nums.length];
        permuteDFS(ans, current, used, nums);
        return ans;
    }
    

    public static void permuteDFS(List<List<Integer>> ans, List<Integer> current, boolean[] used, int[] nums) {
        if (current.size() == nums.length) {
           ans.add(new LinkedList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true ;
            current.add(nums[i]);
            permuteDFS(ans, current, used, nums);
            current.remove(current.size() - 1);
            used[i] = false ;

        }
    }


}