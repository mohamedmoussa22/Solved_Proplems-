import java.util.Arrays;

public class App {
    public static void reverseString(char[] s) {
        int leftPointer =0 , rightPointer = s.length -1 ;
        while (leftPointer < rightPointer){
            swapChar(s, leftPointer, rightPointer);
            leftPointer++;
            rightPointer--;
        } 
    }
        public static void swapChar (char arr[] , int indexFrom ,int indexTo ){
        char temp = arr[indexFrom];
        arr[indexFrom] = arr[indexTo];
        arr[indexTo] = temp;
    }
    public static void main(String[] args) throws Exception {
        char inputArr [] = { 'h','e','l','l','o'};
        reverseString(inputArr);
        System.out.println(Arrays.toString(inputArr));
    }
}
