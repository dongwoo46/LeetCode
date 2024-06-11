class Solution {
    int[] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        target = Math.abs(target);

        if ((target + total) % 2 == 1) {
            return 0;
        }

        int s1 = (target + total) / 2;
        dp = new int[s1 + 1];
        dp[0] = 1;
        find(nums, 0, s1);
        return dp[s1];
    }

    private void find(int[] nums, int index, int target) {
        if (index == nums.length) {
            return;
        }

        for (int n = target; n >= nums[index]; n--) {
            dp[n] = dp[n] + dp[n - nums[index]];
        }

        find(nums, index + 1, target);
    }
}