class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int minn = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++) {
            int min = Math.abs(nums[i] - nums[i+1]);
            minn = Math.min(minn,min);
        }
        for(int i = 0; i < n - 1; i++) {
            int min = Math.abs(nums[i] - nums[i+1]);
            List<Integer> ans = new ArrayList<>();
            ans.add(nums[i]);
            ans.add(nums[i+1]);
            if(minn == min) list.add(ans);
        }
        return list;


    }
}