package UnionFind;

public class findRedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {

        int n=edges.length;
        //edges从1开始，dsu从0开始
        UF uf=new UF(n+1);
        for (int[] e: edges){
            if(!uf.union(e[0],e[1])) return e;
        }
        return new int[0];
    }
}
