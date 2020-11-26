package UnionFind;

public class GraphValidTree {

    public static boolean validTree(int n, int[][] edges) {
        UF uf=new UF(n);
        for(int[] e:edges){
            if(!uf.union(e[0],e[1])) return false;
        }

        return edges.length==n-1;
    }

    public static void main(String[] args) {
        int[][] edges={{0,1},{2,4}};
        System.out.println(validTree(4,edges));
    }
}
