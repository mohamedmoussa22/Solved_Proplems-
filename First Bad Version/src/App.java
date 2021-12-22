public class App {
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
         int first = 1 ,last = n  , mid ;
          while (first < last ){
              mid = first + ( last - first ) / 2 ;
              if (isBadVersion(mid)){
                  last = mid;
              }
              else {
                  first = mid + 1 ;
              }
              
          }
            return last;
     }
 }
    public static void main(String[] args) throws Exception {
       // USE IT 
    }
}
