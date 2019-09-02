package com.david.algorithms;

public class LowestCommonAncestor {

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
      left = null;
      right = null;
    }
  }

  static int ans = -1;

  public static boolean findN(TreeNode node, int B, int C) {

    if (ans != -1) return false;
    if (node == null) return false;

    boolean left = findN(node.left, B, C);
    boolean right = findN(node.right, B, C);
    if (node.val == B || node.val == C) {
      if (B == C) {
        ans = node.val;
        return true;
      }
      if (left || right) {
        ans = node.val;
        return true;
      }
      return true;
    }
    if (left && right) {
      ans = node.val;
      return true;
    }
    return left || right;
  }

  public static int lca(TreeNode A, int B, int C) {

    findN(A, B, C);
    return ans;
  }

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(1);
    tree.left = new TreeNode(2);
    tree.right = new TreeNode(3);
    tree.left.left = new TreeNode(4);
    tree.left.right = new TreeNode(5);
    tree.right.left = new TreeNode(6);
    tree.right.right = new TreeNode(7);

    System.out.println("LCA(4, 5): " + lca(tree, 4, 5));
    //    System.out.println("LCA(4, 6): " + lca(tree, 4, 6));
    //    System.out.println("LCA(3, 4): " + lca(tree, 3, 4));
    //    System.out.println("LCA(2, 4): " + lca(tree, 2, 4));
  }
}
