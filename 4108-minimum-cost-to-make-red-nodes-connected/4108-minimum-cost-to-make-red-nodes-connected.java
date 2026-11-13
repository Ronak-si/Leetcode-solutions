import java.util.*;

class Solution {
    List<List<Integer>> adj;
    char[] colorsArr;
    long[] size;
    long[] dp;
    long maxW = 0;

    public long minCost(int n, String colors, int[][] edges) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        colorsArr = colors.toCharArray();
        size = new long[n];
        dp = new long[n];

        dfsSize(0, -1);

        long allBlueCost = 0;
        for (int i = 0; i < n; i++) {
            if (colorsArr[i] == 'R') allBlueCost += size[i];
        }

        dfsDp(0, -1);

        return allBlueCost - maxW;
    }

    void dfsSize(int u, int p) {
        size[u] = 1;
        for (int v : adj.get(u)) {
            if (v != p) {
                dfsSize(v, u);
                size[u] += size[v];
            }
        }
    }

    void dfsDp(int u, int p) {
        dp[u] = (colorsArr[u] == 'R') ? size[u] : -size[u];
        for (int v : adj.get(u)) {
            if (v != p) {
                dfsDp(v, u);
                if (dp[v] > 0) dp[u] += dp[v];
            }
        }
        maxW = Math.max(maxW, dp[u]);
    }
}