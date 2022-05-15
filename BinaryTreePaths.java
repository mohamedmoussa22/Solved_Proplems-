public class BinaryTreePaths {

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
    
}
