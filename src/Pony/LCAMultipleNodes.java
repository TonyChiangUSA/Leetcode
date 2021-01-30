package Pony;

import Tree.TreeNode;

import java.util.HashSet;

public class LCAMultipleNodes {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> set = new HashSet<>();
        for (TreeNode n : nodes) set.add(n.val);
        return traverse(root,set);
    }

    public TreeNode traverse(TreeNode node,HashSet<Integer> set) {
        if (node == null) return null;
        if (set.contains(node.val)) return node;
        TreeNode left = traverse(node.left,set);
        TreeNode right = traverse(node.right,set);
        // 情况 1
        if (left != null && right != null) {
            return node;
        }
        // 情况 2
        if (left == null && right == null) {
            return null;
        }
        // 情况 3
        return left == null ? right : left;
    }
}
