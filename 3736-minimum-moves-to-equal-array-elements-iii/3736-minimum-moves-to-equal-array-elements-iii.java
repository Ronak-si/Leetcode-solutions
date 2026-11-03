class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int a=0;
        for(int i=0;i<n-1;i++){
            a+=nums[n-1]-nums[i];
        }
        return a;
    }
}