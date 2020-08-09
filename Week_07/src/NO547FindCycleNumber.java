public class NO547FindCycleNumber {
    // 连通分量个数
    private int count;
    // 存储一棵树
    private int[] parent;
    // 记录树的“重量”
    private int[] size;

    public static void main(String[] args) {
        int[][] grids = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        int[][] grids2 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1}
        };
        int[][] grids3 = {
                {1, 1, 1},
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] grids4 = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        System.out.println(new NO547FindCycleNumber(grids.length).findCircleNum(grids));
        System.out.println(new NO547FindCycleNumber(grids2.length).findCircleNum(grids2));
        System.out.println(new NO547FindCycleNumber(grids3.length).findCircleNum(grids3));
        System.out.println(new NO547FindCycleNumber(grids4.length).findCircleNum(grids4));
    }

    //并查集解法:find,union
    int findCircleNum(int[][] M) {
        int n = M.length;
        NO547FindCycleNumber uf = new NO547FindCycleNumber(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }


    NO547FindCycleNumber(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // 合并树：将小树合到大树
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    int find(int x) {
        while (parent[x] != x) {
            // 路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    int count() {
        return count;
    }
}
