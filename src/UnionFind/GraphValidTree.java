package UnionFind;

import java.util.Arrays;

public class GraphValidTree {

        public int minimumCost(int N, int[][] connections) {
            UF uf = new UF(N);
            Arrays.sort(connections, (a, b) -> a[2] - b[2]);
            int total = 0;
            int cost = 0;
            for (int i = 0; i < connections.length; ++i) {
                int a = connections[i][0];
                int b = connections[i][1];

                if (!uf.union(a, b)) continue;

                uf.union(a, b);

                cost += connections[i][2];

                total++;
            }
            // If all N nodes are connected, the MST will have a total of N - 1 edges
            if (total == N - 1) {
                return cost;
            } else {
                return -1;
            }
        }

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
