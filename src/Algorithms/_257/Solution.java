package Algorithms._257;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root.left == null && root.right == null) return List.of("" + root.val);

        checkNode(root, "");
        return result;
    }


    private void checkNode(TreeNode node, String path) {
        if (node.left != null) checkNode(node.left, path + node.val + "->");

        if (node.right != null) checkNode(node.right, path + node.val + "->");

        if (node.left == null && node.right == null) result.add(path + node.val);
    }
}