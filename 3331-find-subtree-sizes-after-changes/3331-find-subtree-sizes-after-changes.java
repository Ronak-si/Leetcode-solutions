class Solution {
    List<List<Integer>> adj;
    int[] last = new int[26];
    int[] ans;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        adj = new ArrayList<>();
        ans = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }

        Arrays.fill(last, -1);

        int[] newParent = parent.clone();

        // Find new parents
        findParent(0, s, newParent);

        // Build modified tree
        for (int i = 0; i < n; i++) {
            adj.get(i).clear();
        }

        for (int i = 1; i < n; i++) {
            adj.get(newParent[i]).add(i);
        }

        // Choose either DFS or BFS
        dfs(0);

        // For BFS, use:
        // bfs(0, newParent);

        return ans;
    }

    void findParent(int node, String s, int[] newParent) {
        int ch = s.charAt(node) - 'a';
        int old = last[ch];

        if (old != -1) {
            newParent[node] = old;
        }

        last[ch] = node;

        for (int child : adj.get(node)) {
            findParent(child, s, newParent);
        }

        last[ch] = old;
    }

    // Method 1: DFS
    int dfs(int node) {
        int size = 1;

        for (int child : adj.get(node)) {
            size += dfs(child);
        }

        ans[node] = size;
        return size;
    }

    // Method 2: BFS
    void bfs(int root, int[] newParent) {
        int n = adj.size();

        Arrays.fill(ans, 1);

        Queue<Integer> q = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);

            for (int child : adj.get(node)) {
                q.offer(child);
            }
        }

        // Process nodes bottom-up
        for (int i = order.size() - 1; i > 0; i--) {
            int node = order.get(i);
            ans[newParent[node]] += ans[node];
        }
    }
}