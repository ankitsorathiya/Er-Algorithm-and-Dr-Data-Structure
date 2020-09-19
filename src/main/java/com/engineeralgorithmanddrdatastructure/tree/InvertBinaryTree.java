package com.engineeralgorithmanddrdatastructure.tree;

/**
 * invert a binary tree
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.setLeft(left);
        root.setRight(right);
        root = invert(root);
        inorder(root);
    }

    public static TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.getLeft();
        root.setLeft(invert(root.getRight()));
        root.setRight(invert(left));
        return root;
    }

    private static void inorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inorder(treeNode.getLeft());
        System.out.println(treeNode.getIntValue());
        inorder(treeNode.getRight());
    }

}
