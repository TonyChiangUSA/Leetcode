package Graph;

import java.util.*;

public class DijkstraInMap {
    /*
    * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
      Output: 2
    *
    * */
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        networkDelayTime(times, 4, 2);
    }

    // O (N logn)
    public static int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> weightAdj = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (int[] a, int[] b) -> a[1] - b[1]
        );

        for (int[] edge : times) {
            List<int[]> nei = weightAdj.getOrDefault(edge[0], new ArrayList<>());
            nei.add(new int[]{edge[1], edge[2]});
            weightAdj.put(edge[0], nei);
        }

        // weightAdj: 2 -> [1,1],[3,1]  3->[4,1]
        int res = Integer.MIN_VALUE;
        // Key is node, value is distance from origin node K. It also acts as a visited set
        Map<Integer, Integer> dist = new HashMap<>();
        pq.add(new int[]{K, 0});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();
            int node = cur[0];
            int dis = cur[1];

            if (dist.containsKey(node)) continue;
            dist.put(node, dis);
            res = Math.max(res, dis);
            if (weightAdj.containsKey(node))
                for (int[] nei : weightAdj.get(node)) {

                    int neiNode = nei[0];
                    int neiDist = nei[1];

                    if (!dist.containsKey(neiNode)) {
                        pq.add(new int[]{neiNode, neiDist + dis});
                    }
                }
        }


        return dist.size() == N ? res : -1;
    }
}

