
import java.util.Arrays;
import java.util.HashMap;

import javax.xml.crypto.Data;



public class App {



    public static int[] twoSum(int[] nums, int target) {
        int output[] = { 0, 0 };
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    output[0] = i;
                    output[1] = j;
                    return output;
                }
            }
        }
        return output;
    }

    public static int[] twoSumSecondApproch(int[] nums, int target) {
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

    public static int maxArea(int[] height) {

        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int x = height[i], y = height[j];
                int calcArea = Math.min(x, y) * (j - i);
                if (calcArea > maxArea) {
                    maxArea = calcArea;
                }
            }

        }
        return maxArea;

    }

    public static int maxAreaOptimized(int[] height) {

        int maxArea = 0, firstIndexPointer = 0, lastIndexPointer = height.length - 1;

        while (firstIndexPointer < lastIndexPointer) {
            if (height[firstIndexPointer] < height[lastIndexPointer]) {
                maxArea = Math.max(maxArea, height[firstIndexPointer] * (lastIndexPointer - firstIndexPointer));
                firstIndexPointer++;

            } else {
                maxArea = Math.max(maxArea, height[lastIndexPointer] * (lastIndexPointer - firstIndexPointer));
                lastIndexPointer--;
            }

        }
        return maxArea;

    }

    public ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {

            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode temp_node = new ListNode(0);
        ListNode outPutNode = temp_node;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                outPutNode.next = list1;
                list1 = list1.next;

            } else {

                outPutNode.next = list2;
                list2 = list2.next;
            }
            outPutNode = outPutNode.next;

        }
        if (list1 == null) {
            outPutNode.next = list2;
        }
        if (list2 == null) {
            outPutNode.next = list1;
        }

        return temp_node.next;

    }

    public static void swap(char[] arr, int firstIndex, int secondIndex) {
        char temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;

    }

    public static void reverseString(char[] s, int leftPointer, int rightPointer) {
        if (leftPointer >= rightPointer) {
            return;
        }
        swap(s, leftPointer, rightPointer);
        reverseString(s, leftPointer + 1, rightPointer - 1);
    }

    /*
     * public static char[] reverseStringVersionTwo(char[] s, int counter) {
     * if (counter == s.length) {
     * return new char[]{ s[counter-1]} ;
     * }
     * reverseStringVersionTwo(s, counter+1);
     * }
     */

    public static String reverseStringRecursivly(String input) {
        if (input.equals("")) {
            return "";
        }
        return reverseStringRecursivly(input.substring(1)) + input.charAt(0);
    }

    public static boolean isPalindrome(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return isPalindrome(input.substring(1, input.length() - 1));
        }
        return false;
    }

    public static StringBuilder cleanString(String input) {

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 65 && input.charAt(i) <= 90) {
                output.append(Character.toLowerCase(input.charAt(i)));
            } else if (input.charAt(i) >= 97 && input.charAt(i) <= 122
                    || input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                output.append(input.charAt(i));
            }

        }
        return output;
    }

    public static String decimalToBinary(int num) {
        if (num == 0) {
            return "";
        }
        if (num % 2 == 0) {
            return decimalToBinary(num / 2) + "0";
        }
        return decimalToBinary(num / 2) + "1";

    }

    public static int sumOfNaturalNumbers(int num) {
        if (num == 1) {
            return num;
        }

        return num + sumOfNaturalNumbers(num - 1);

    }

    public static int binarySearch(int [] arr ,  int left , int right, int target ){
               if (left > right ){
                   return -1 ;
               }
               int mid = (left+ right) / 2;
               if ( arr[mid] == target ){
                     return mid;
               }
               if ( target < arr[mid]){
                   return binarySearch(arr, left ,mid - 1, target);
               }
               return binarySearch(arr,mid + 1,right, target);
    }

    public static int febonacci (int x ){
        if (x == 1 || x== 0 ){
            return x;

        }

        return febonacci(x - 1 ) + febonacci( x-2 );
    }

    public static void mergeSort(int arr [] , int start , int  end ){
          if (start < end ){
              int mid =  (start + end ) / 2;
               mergeSort(arr, start, mid);
               mergeSort(arr, mid+1, end);
               merge(arr,start,mid,end);

          }
    }
    public static void merge(int arr[] , int start , int mid , int end ){
           int temp[] = new int [end - start + 1];
           int i = start , j = mid + 1 , k=0;
           while(i <= mid && j <= end ){
               if (arr[i] <= arr[j]){
                   temp[k++] = arr[i++];                  
               }
               else {
                    temp[k++] = arr[j++];
               }
           }
           while(i  <= mid ){
               temp[k++] = arr[i++];
           }
           while(j  <= end ){
            temp[k++] = arr[j++];

          
        }
        for ( i = start ; i <= end ; i++){
            arr[i] = temp[i - start ];
          }
    }


    public static ListNode reverseLinkedList(ListNode head ){
      if ( head.next== null){
            return head;

      }
      return reverseLinkedList(head.next);

    }

    public static void printLinkedList (ListNode head ){
        ListNode step  = head;
              while(step != null){
                  System.out.println(step.val + " ");
              }
    }



    public static void main(String[] args) throws Exception {
        // char[] string = {'h','e','l','l','o'};

        // reverseString(string, 0, string.length-1);
        // reverseStringVersionTwo(string,0);
        // String x = "A man, a plan, a canal: Panama";
        // String y = x.substring(0 , x.length() - 1);
        // boolean checkPalindrome = isPalindrome(x);
        // String binary = decimalToBinary(233);
        // int sum = sumOfNaturalNumbers(5);
        //int []arr = {-1,-2,5,3,2,1,0};
        //int index = binarySearch(arr, 0,arr.length  -1, 9) ;
        //int feb = febonacci(7);
        //mergeSort(arr, 0, arr.length - 1 );
       ListNode one = new ListNode(1);
       ListNode two = new ListNode(2);
       ListNode three = new ListNode(3);
       ListNode four = new ListNode(4);
       ListNode five = new ListNode(5);
       one.next = two;
       two.next = three;
       three.next = four;
       four.next = five;

       printLinkedList(one);

       
        // System.out.println(Arrays.toString(string));
    }
}
