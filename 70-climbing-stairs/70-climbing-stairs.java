class Solution {
    public static int climbStairs(int n) {
        HashMap <Integer , Integer> map= new HashMap<>();
        return dbClimbStarts(n, map);
    }
    
    public static int dbClimbStarts (int n , HashMap <Integer , Integer> map ){
    
        if (n == 0 ){
            return 1;
        }   
        if (n < 0){
            return 0;
        }

        if (!map.containsKey(n)){
            int var  = dbClimbStarts( n - 1 , map) + dbClimbStarts(n - 2 , map)  ;
            map.put(n, var);    
          }
        return map.get(n);
         
    }
}