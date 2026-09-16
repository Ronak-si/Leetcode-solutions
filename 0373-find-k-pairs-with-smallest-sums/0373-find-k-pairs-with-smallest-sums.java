class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
    
        int n = nums1.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[0] + a[1]) - (b[0] + b[1])
        );
        for (int i = 0; i < Math.min(n, k); i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            res.add(Arrays.asList(curr[0], curr[1]));
            int nextJ = curr[2] + 1;
            if (nextJ < nums2.length) {
                pq.offer(new int[]{curr[0], nums2[nextJ], nextJ});
            }
        }
        
        return res;
    }
}