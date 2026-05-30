package Algorithms._222;

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
    private int maxDepth;

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1;

        maxDepth = findLDepth(root);

        return (int) Math.pow(2, maxDepth) - countMissing(root, 1) - 1;

    }

    public int countMissing(TreeNode node, int currentDepth) {
        int sum = 0;
        if (node.right != null) {
            sum += countMissing(node.right, currentDepth + 1);
        } else {
            if (currentDepth == maxDepth) {
                return 0;
            }
            return node.left == null ? 2 : 1;
        }
        sum += countMissing(node.left, currentDepth + 1);
        return sum;
    }

    public int findLDepth(TreeNode node) {
        return node.left != null ? 1 + findLDepth(node.left) : 1;
    }
}