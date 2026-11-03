class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = nums[n-1];
        int count = 0;
        for(int i = 0; i < n - 1;i++) {
            count += max - nums[i];
        }
        return count;
    }
}