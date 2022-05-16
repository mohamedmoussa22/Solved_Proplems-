import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.management.relation.Role;
import javax.sound.sampled.Line;

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

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (target < arr[mid]) {
            return binarySearch(arr, left, mid - 1, target);
        }
        return binarySearch(arr, mid + 1, right, target);
    }

    public static int febonacci(int x) {
        if (x == 1 || x == 0) {
            return x;

        }

        return febonacci(x - 1) + febonacci(x - 2);
    }

    public static void mergeSort(int arr[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);

        }
    }

    public static void merge(int arr[], int start, int mid, int end) {
        int temp[] = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];

        }
        for (i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
    }

    public static ListNode reverseLinkedList(ListNode head) {
        if (head.next == null) {
            return head;

        }
        ListNode lastNode = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;

        return lastNode;

    }

    public static void printLinkedList(ListNode head) {
        ListNode step = head;
        while (step != null) {
            System.out.println(step.val + " ");
            step = step.next;
        }
    }

    public static ListNode mergeTwoSortedLinkedList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoSortedLinkedList(list1.next, list2);
            return list1;

        }
        list2.next = mergeTwoSortedLinkedList(list1, list2.next);
        return list2;
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }

    public boolean isPowerOfTwo(int n) {

        if (n == 0 || (n % 2 != 0 && n != 1)) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        return isPowerOfTwo(n / 2);
    }

    public static void swapIntArray(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;

    }

    public static void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int rightPointer = nums.length - 1;
        int leftPointer = nums.length - 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[rightPointer] > nums[leftPointer]) {
                swapIntArray(nums, rightPointer, leftPointer);
                return;
            }
            if (leftPointer > 0) {
                rightPointer--;
                leftPointer--;
            }

        }

        Arrays.sort(nums);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void printAllLeafNodes(TreeNode root) { // leaf node is node that doesn't have child
        if (root == null)
            return;
        if (root.right == null && root.left == null) {
            System.out.println(root.val);
            return;
        }
        printAllLeafNodes(root.left);
        printAllLeafNodes(root.right);
    }

    public static int[] twoSum1(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complimnet = target - numbers[i];
            if (map.containsKey(complimnet)) {
                return new int[] { map.get(complimnet) + 1, i + 1 };
            } else {
                map.put(numbers[i], i);
            }
        }

        throw new IllegalArgumentException("NO match Found");
    }

    public static int lengthOfLongestSubstring(String s) {
        int a_pointer = 0, b_pointer = 0, outPut = 0;
        HashSet<Character> map = new HashSet<>();
        while (b_pointer < s.length()) {
            if (!map.contains(s.charAt(b_pointer))) {
                map.add(s.charAt(b_pointer));
                outPut = Math.max(outPut, map.size());
                b_pointer++;
            } else {
                map.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return outPut;
    }

    public static boolean checkInclusion(String s1, String s2) { // Sliding window

        if (s1.length() > s2.length()) {
            return false;
        }
        int[] smallString = new int[26];
        int[] bigString = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            smallString[s1.charAt(i) - 'a']++;
            bigString[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(smallString, bigString)) {
                return true;
            }
            bigString[s2.charAt(i + s1.length()) - 'a']++;
            bigString[s2.charAt(i) - 'a']--;

        }
        return matches(smallString, bigString);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> outPut = new ArrayList<>();
        if (p.length() > s.length()) {
            return outPut;
        }

        int[] forStringS = new int[26];
        int[] forStringP = new int[26];
        for (int i = 0; i < p.length(); i++) {
            forStringS[s.charAt(i) - 'a']++;
            forStringP[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (matches(forStringS, forStringP)) {
                outPut.add(i);
            }

            forStringS[s.charAt(i + p.length()) - 'a']++;
            forStringS[s.charAt(i) - 'a']--;
        }
        if (matches(forStringS, forStringP)) {
            outPut.add(s.length() - p.length());

        }

        return outPut;
    }

    public static List<Integer> findAnagramsOptimizedVersion(String s, String p) {

        List<Integer> outPut = new ArrayList<>();
        if (p.length() > s.length()) {
            return outPut;
        }
        int counter = 0;
        int[] forStringS = new int[26];
        int[] forStringP = new int[26];
        for (int i = 0; i < p.length(); i++) {
            forStringS[s.charAt(i) - 'a']++;
            forStringP[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (forStringS[i] == forStringP[i]) {
                counter++;
            }
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (counter == 26) {
                outPut.add(i);
            }

            forStringS[s.charAt(i + p.length()) - 'a']++;
            forStringS[s.charAt(i) - 'a']--;
        }
        if (matches(forStringS, forStringP)) {
            outPut.add(s.length() - p.length());

        }

        return outPut;
    }

    public static boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (image[sr][sc] != newColor)
            dfs(image, sr, sc, color, newColor);
        return image;
    }

    public static void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        if (image[sr][sc] == color) {
            image[sr][sc] = newColor;
            if (sr >= 1)
                dfs(image, sr - 1, sc, color, newColor);
            if (sc >= 1)
                dfs(image, sr, sc - 1, color, newColor);
            if (sr + 1 < image.length)
                dfs(image, sr + 1, sc, color, newColor);
            if (sc + 1 < image[0].length)
                dfs(image, sr, sc + 1, color, newColor);
        }

    }

    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    continue;
                }
                if (grid[r][c] == 1) {
                    perimeter += 4;
                }
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    perimeter -= 2;
                }

                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    perimeter -= 2;
                }

            }
        }
        return perimeter;
    }

    public static int islandPerimeterSecondVersion(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1)
                    return islandPerimeterWithDFS(grid, visited, r, c);

            }
        }
        return 0;
    }

    public static int islandPerimeterWithDFS(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 1;
        }
        if (grid[row][col] == 0)
            return 1;
        if (visited[row][col])
            return 0;
        visited[row][col] = true;

        int perimeter = 0;
        perimeter += islandPerimeterWithDFS(grid, visited, row, col + 1);
        perimeter += islandPerimeterWithDFS(grid, visited, row, col - 1);
        perimeter += islandPerimeterWithDFS(grid, visited, row - 1, col);
        perimeter += islandPerimeterWithDFS(grid, visited, row + 1, col);

        return perimeter;

    }

    // s = "xywrrmp ,t = "xywrrmu#p"
    public static boolean backspaceCompare(String s, String t) {
        int leftPointerS = s.length() - 1, skipCounterForS = 0;
        int leftPointerT = t.length() - 1, skipCounterForT = 0;
        while (leftPointerS >= 0 || leftPointerT >= 0) {
            while (leftPointerS >= 0) {
                if (s.charAt(leftPointerS) == '#') {
                    skipCounterForS++;
                    leftPointerS--;
                } else if (skipCounterForS > 0) {
                    skipCounterForS--;
                    leftPointerS--;
                } else
                    break;
            }
            while (leftPointerT >= 0) {
                if (t.charAt(leftPointerT) == '#') {
                    skipCounterForT++;
                    leftPointerT--;
                } else if (skipCounterForT > 0) {
                    skipCounterForT--;
                    leftPointerT--;
                } else
                    break;
            }
            if (leftPointerS >= 0 && leftPointerT >= 0 && s.charAt(leftPointerS) != t.charAt(leftPointerT))
                return false;

            if ((leftPointerS >= 0) != (leftPointerT >= 0))
                return false;

            leftPointerS--;
            leftPointerT--;

        }

        return true;
    }

    public static int[] sortArrayByParity(int[] nums) {
        int leftPinter = 0, rightPointer = nums.length - 1;
        while (leftPinter < rightPointer) {
            if (nums[leftPinter] % 2 != 0 && nums[rightPointer] % 2 == 0) {
                swapIntArray(nums, leftPinter, rightPointer);

            }
            if (nums[leftPinter] % 2 == 0)
                leftPinter++;
            if (nums[rightPointer] % 2 != 0)
                rightPointer--;
        }
        return nums;
    }

    /*
     * public static int findUnsortedSubarray(int[] nums) {
     * if (nums.length == 1) {
     * return 0;
     * }
     * int leftPointer = 0, rightPointer = nums.length - 1, outPut = 0;
     * 
     * while (nums[leftPointer] <= nums[leftPointer + 1]) {
     * leftPointer++;
     * outPut++;
     * if (leftPointer + 1 == nums.length) {
     * outPut++;
     * break;
     * }
     * 
     * }
     * if (leftPointer < rightPointer) {
     * while (nums[rightPointer] > nums[rightPointer - 1] && nums[leftPinter] ) {
     * rightPointer--;
     * outPut++;
     * }
     * }
     * 
     * return nums.length - outPut;
     * }
     */

    public static int findMaxConsecutiveOnes(int[] nums) {
        int outPut = 0, counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                outPut = Math.max(outPut, counter);
                counter = 0;
            } else {
                counter++;
            }
        }
        return Math.max(outPut, counter);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    maxArea = Math.max(dfsMaxAreaOfIsland(grid, visited, row, col), maxArea);
                }
            }
        }
        return maxArea;
    }

    public static int dfsMaxAreaOfIsland(int[][] grid, boolean[][] visited, int row, int col) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        if (visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;

        return 1 + dfsMaxAreaOfIsland(grid, visited, row, col - 1) +
                dfsMaxAreaOfIsland(grid, visited, row, col + 1) +
                dfsMaxAreaOfIsland(grid, visited, row - 1, col) +
                dfsMaxAreaOfIsland(grid, visited, row + 1, col);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val) {
            return root;
        }
        if (val <= root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void insertIntoBinaryTree(TreeNode root, int val) {

        if (root == null) {
            root = new TreeNode(val);
            return;
        }

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        while (!que.isEmpty()) {
            root = que.peek();
            que.remove();

            if (root.left == null) {
                root.left = new TreeNode(val);
                break;
            } else {
                que.add(root.left);
            }

            if (root.right == null) {
                root.left = new TreeNode(val);
                break;
            } else {
                que.add(root.right);
            }

        }

    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    public static void treeTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        treeTraversal(root.left);
        System.out.println(root.val);
        treeTraversal(root.right);

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }

            else if (!stack.empty()) {

                if (stack.peek() == '(' && s.charAt(i) == ')' || stack.peek() == '{' && s.charAt(i) == '}'
                        || stack.peek() == '[' && s.charAt(i) == ']') {
                    stack.pop();
                } else
                    return false;

            } else {
                return false;
            }
        }

        return stack.size() == 0;
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return ans;
        }

        String[] lettersMap = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        backtrack(ans, new StringBuilder(), digits, lettersMap, 0);
        return ans;
    }

    public static void backtrack(List<String> res, StringBuilder sb, String digits, String[] lettersMap, int idx) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int number = digits.charAt(idx) - '0';
        String numStr = lettersMap[number - 2];
        for (int i = 0; i < numStr.length(); i++) {
            sb.append(numStr.charAt(i));
            backtrack(res, sb, digits, lettersMap, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /*
     * public static List<List<Integer>> permute (int[] nums) {
     * List<List<Integer>> ans = new ArrayList<>();
     * List<Integer>holder = new ArrayList<>();
     * backtrack(nums, holder, ans, 0);
     * return ans;
     * }
     * 
     * public static void backtrack( int [] nums, List<Integer> holder ,
     * List<List<Integer>> ans , int index ){
     * if (index == nums.length){
     * ans.add(holder);
     * return;
     * }
     * 
     * for (int i = 0; i < nums.length; i++ ){
     * holder.add(nums[index]);
     * backtrack(nums, holder, ans , index + 1);
     * holder.remove(o);
     * }
     * }
     */

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        String path = Integer.toString(root.val);
        if (root.right == null && root.left == null) {
            output.add(path);
        }
        if (root.left != null) {
            backtrack(root.left, output, path);
        }
        if (root.right != null) {
            backtrack(root.right, output, path);
        }

        return output;
    }

    public static void backtrack(TreeNode root, List<String> output, String path) {
        path += "->" + root.val;
        if (root.right == null && root.left == null) {
            output.add(path);
            return;
        }
        if (root.left != null) {
            backtrack(root.left, output, path);
        }

        if (root.right != null) {
            backtrack(root.right, output, path);
        }

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> holder = new ArrayList<>();
        dfs(ans, holder, nums, 0);
        return ans;
    }

    public static void dfs(List<List<Integer>> ans, List<Integer> holder, int[] nums, int i) {
    
        if (i >= nums.length) {
            ans.add(new ArrayList<>(holder));
            return;
        }
        holder.add(nums[i]);
        dfs(ans, holder, nums, i + 1);

        holder.remove(holder.size() - 1);
        dfs(ans, holder, nums, i + 1);
    }

    public static List<List<Integer>> subsetsTwo(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> holder = new ArrayList<>();
        dfs(ans, holder, nums, 0);
        return ans;
    }
    public static void dfsTwo(List<List<Integer>> ans, List<Integer> holder, int[] nums, int i) {
    
        if (i >= nums.length) {
            ans.add(new ArrayList<>(holder));
            return;
        }
        holder.add(nums[i]);
        dfs(ans, holder, nums, i + 1);

        holder.remove(holder.size() - 1);
        dfs(ans, holder, nums, i + 1);
    }

    /*
     * Math.max(
     * Math.max(
     * Math.max(maxArea += dfsMaxAreaOfIsland(grid, visited, row, col - 1),
     * maxArea += dfsMaxAreaOfIsland(grid, visited, row, col + 1)),
     * maxArea += dfsMaxAreaOfIsland(grid, visited, row + 1, col)),
     * maxArea += dfsMaxAreaOfIsland(grid, visited, row - 1, col))
     */

    public static void main(String[] args) throws Exception {
        // char[] string = {'h','e','l','l','o'};

        // reverseString(string, 0, string.length-1);
        // reverseStringVersionTwo(string,0);
        // String x = "A man, a plan, a canal: Panama";
        // String y = x.substring(0 , x.length() - 1);
        // boolean checkPalindrome = isPalindrome(x);
        // String binary = decimalToBinary(233);
        // int sum = sumOfNaturalNumbers(5);
        // int []arr = {-1,-2,5,3,2,1,0};
        // int index = binarySearch(arr, 0,arr.length -1, 9) ;
        // int feb = febonacci(7);
        // mergeSort(arr, 0, arr.length - 1 );
        /*
         * ListNode one = new ListNode(7);
         * ListNode two = new ListNode(7);
         * ListNode three = new ListNode(7);
         * ListNode four = new ListNode(7);
         * ListNode five = new ListNode(7);
         * ListNode six = new ListNode(7);
         * ListNode seven = new ListNode(7);
         * one.next = two;
         * two.next = three;
         * three.next = four;
         * four.next = five;
         * five.next = six;
         * six.next = seven;
         * 
         * 
         * printLinkedList(removeElements(one, 7));
         */

        /*
         * int arr [] = {3,2,1};
         * nextPermutation(arr);
         * System.out.println(Arrays.toString(arr));
         */

        /*
         * TreeNode root1 = new TreeNode(1);
         * root1.left = new TreeNode(2);
         * root1.left.right = new TreeNode(5);
         * root1.right = new TreeNode(3);
         * 
         * binaryTreePaths(root1).forEach(System.out::println);
         */

        /*
         * TreeNode root2 = new TreeNode(2);
         * root2.left= new TreeNode(1);
         * root2.left.right = new TreeNode(4);
         * root2.right = new TreeNode(3);
         * root2.right.right = new TreeNode(7);
         */

        /*
         * insertIntoBinaryTree(root, 3);
         * insertIntoBinaryTree(root, 2);
         * insertIntoBinaryTree(root, 5);
         * 
         * /*
         * insertIntoBST(root, 80);
         * insertIntoBST(root, 50);
         * insertIntoBST(root, 30);
         * insertIntoBST(root, 60);
         * insertIntoBST(root, 90);
         * insertIntoBST(root, 85);
         * insertIntoBST(root, 95);
         * insertIntoBST(root, 120);
         * insertIntoBST(root, 110);
         * insertIntoBST(root, 108);
         * insertIntoBST(root, 115);
         * insertIntoBST(root, 140);
         * insertIntoBST(root, 150);
         * //printAllLeafNodes(root);
         */
        // treeTraversal(mergeTrees(root1, root2));

        // int outPut = lengthOfLongestSubstring("pwwkew");
        // String first = "baa" , second = "aa";

        // checkInclusion(first, second)
        // int[][] image = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0,
        // 0 } };
        // System.out.println(Arrays.toString(findAnagrams(first, second).toArray()));
        // System.out.println(islandPerimeterSecondVersion(image));

        // String one = "xywrrmp", two = "xywrrm#p";
        // int nums[] = { 1, 1, 0, 1, 1, 1 };
        /*
         * int grid[][] = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0,
         * 0, 0, 1, 1, 1, 0, 0, 0 },
         * { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1,
         * 0, 0 },
         * { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
         * 0, 0 },
         * { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0,
         * 0, 0 } };
         * System.out.println(maxAreaOfIsland(grid));
         */

        // System.out.println(Arrays.toString(string));
        // System.out.println(isValid("()"));

        List<List<Integer>> result = subsets(new int[] { 1, 2, 3 });
        System.out.println("Here is the list of subsets: " + result);

        // . letterCombinations("23").forEach(System.out::println);;
    }
}
