public class reverseString {

    public static void swap(char[] arr, int firstIndex, int secondIndex) {
        char temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;

    }
      // Recusive 
    public static void reverseStringg(char[] s, int leftPointer, int rightPointer) {
        if (leftPointer >= rightPointer) {
            return;
        }
        swap(s, leftPointer, rightPointer);
        reverseStringg(s, leftPointer + 1, rightPointer - 1);
    }
    
}
