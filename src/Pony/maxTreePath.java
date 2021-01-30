package Pony;

import Tree.TreeNode;

public class maxTreePath {
    static int res=Integer.MIN_VALUE;
    private static int maxPath(TreeNode root){
        if(root==null) return 0;
        helper(root,0);
        return res;
    }

    private static void helper(TreeNode root,int path){
        if(root==null) return;
        if(root.left==null && root.right==null){
            res=Math.max(res,path+root.val);
            return;
        }
        helper(root.left,path+root.val);
        helper(root.right,path+root.val);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(1);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(3);

        System.out.println(maxPath(root));

    }
}
