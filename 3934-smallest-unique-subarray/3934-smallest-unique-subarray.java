class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        final long BASE = 911382323L; 
        // large random base to represent number
        // similar to 1234 = 1*10^3 + 2*10^2 + 3*10 + 4
        // hash = a*BASE^3 + b*BASE^2 + c*BASE + d

        long[] power = new long[n + 1]; // to store power of base
        long[] pref = new long[n + 1];  // pref[i] stores hash of first i elements.

        power[0] = 1;

        for (int i = 0; i < n; i++) {
            power[i + 1] = power[i] * BASE;
            pref[i + 1] = pref[i] * BASE + nums[i] + 1;
        }

        int low = 1, high = n;
        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // to check if there is any unique subarray of length mid
            HashMap<Long, Integer> freq = new HashMap<>();

            // generate all subarray hashes
            for (int i = 0; i + mid - 1 < n; i++) {

                int l = i;
                int r = i + mid - 1;

                // give hash of subarray l to r
                long hash = pref[r + 1] - pref[l] * power[r - l + 1];

                freq.put(hash, freq.getOrDefault(hash, 0) + 1);
            }

            boolean found = false;

            // iterating over the map and checking if any subarray has freq 1
            for (int cnt : freq.values()) {
                if (cnt == 1) {
                    found = true;
                    break;
                }
            }

            if (found) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}