package UnionFind;


public class UF {
    int[] root;
    //union by size 把节点较少的树合并到节点较多的集合
    int[] size;

    public UF(int n) {
        root = new int[n];
        size = new int[n];

        //初始化节点父亲指向它自己
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }

    //使用path compression优化性能：节点指向最top的父亲几点
    public int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
        }
        return root[x];
    }

    //Union by size 优化性能：把把节点较少的树合并到节点较多的集合
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        //不需要union
        if (rootX == rootY) return false;

        //小集合合并到大集合
        if (size[rootX] < size[rootY]) {
            root[rootX] = rootY;
            size[rootY]++;
        } else {
            root[rootY] = rootX;
            size[rootX]++;
        }

        return true;

    }


}
