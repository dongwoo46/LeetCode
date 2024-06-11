


class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int idx = nums.length -1 ;
        return dfs(nums, 0, target,idx);
        
    }

     public int dfs(int[] nums, int curr_sum, int target, int idx) {
        if (idx < 0 && curr_sum == target) {
            return 1;
        }
        if (idx < 0) {
            return 0;
        }

        int positive = dfs(nums, curr_sum + nums[idx], target, idx - 1);
        int negative = dfs(nums, curr_sum - nums[idx], target, idx - 1);

        return positive + negative;
    }
}