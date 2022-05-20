class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer>holder = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        dbcombinationSum( candidates ,target, 0 , 0,  holder , ans);
        return ans; 
    }
    
        public static void dbcombinationSum(int [] candidates , int target , int total ,int index ,List<Integer>current, List<List<Integer>> ans){
        if (target == total){
           ans.add(new ArrayList<>(current));
            return;
        }
         if (total > target || index >= candidates.length){
            return;
        }
        current.add(candidates[index]);
        dbcombinationSum(candidates, target , total+candidates[index] , index, current, ans);
        current.remove(current.size() - 1);
        dbcombinationSum(candidates, target, total, index + 1, current, ans);
    }
}