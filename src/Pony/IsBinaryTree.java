package Pony;

import Tree.TreeNode;
import UnionFind.UF;

import java.util.*;
import java.util.Map;

public class IsBinaryTree {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        UF uf=new UF(n);
        for(int[] e:edges){
            if(!uf.union(e[0],e[1])) return false;
        }

        return true;
    }
}
