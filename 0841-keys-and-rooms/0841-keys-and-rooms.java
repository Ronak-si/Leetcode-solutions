class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];

        dfs(rooms, 0, vis);

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                return false;
            }
        }

        return true;
    }

    private void dfs(List<List<Integer>> rooms, int i, boolean[] vis){
        vis[i] = true;

        for(int j = 0; j < rooms.get(i).size(); j++){
            int key = rooms.get(i).get(j);

            if(!vis[key]){
                dfs(rooms, key, vis);
            }
        }
    }
}