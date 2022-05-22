class Solution {
    public int minCostClimbingStairs(int[] cost) {
               int [] copy  = new int [cost.length + 1]; 
          for (int i = 0 ; i < cost.length ; i++ ){
            copy[i] = cost[i];   
        }

          for (int i = copy.length - 3 ; i >= 0 ; i--){
              copy[i] += Math.min(copy[i+1], copy[i+2]);   
          }

          return Math.min(copy[0],copy[1]);
    }
}