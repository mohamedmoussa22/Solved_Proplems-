public class App {

    public static String reverseWords(String s) {
        String outPut = "";
       String stringIwillSwap = "";

       String words [] = s.split(" ");
       for(int i =0 ; i < words.length ;i++){
           if (i ==  words.length - 1){
               stringIwillSwap =reverseString(words[i]);
               outPut+= stringIwillSwap;
           }
           else {
               stringIwillSwap =reverseString(words[i]);
               outPut+= stringIwillSwap + " ";
  
               stringIwillSwap = "";
           }
          
       }
       return outPut;
   }
       public static String  reverseString(String s ) {
       String outPut = "";
      int  rightPointer = s.length() -1 ;
       while ( rightPointer >=0){
           outPut+= s.charAt(rightPointer);
           rightPointer--;
       }
       
       return outPut; 
   }
    public static void main(String[] args) throws Exception {
        String input = "Let's take LeetCode contest";
        String output = reverseWords(input);
        System.out.println(output);
    }
}
