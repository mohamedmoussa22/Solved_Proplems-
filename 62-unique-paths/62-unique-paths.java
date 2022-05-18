class Solution {
     public static int uniquePaths(int m, int n) {
      int outPut = db(m, n, new Integer [m + 1][n + 1]);

      return outPut;
 
    }
        public static int db( int m , int n , Integer [][]arr){
        if (arr[m][n] != null){
            return arr[m][n];
        }
        if (m == 1 & n == 1 ){
            return 1 ;
        }
        if( m ==0 || n == 0){
            return 0;

        }
            return  arr[m][n] = db(m, n-1 , arr) + db(m-1, n , arr);
    
    } 
}