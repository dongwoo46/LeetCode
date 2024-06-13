/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var findTargetSumWays = function(nums, target) {
    const total = nums.reduce((acc, num) => acc + num, 0);
    target = Math.abs(target);

    if ((target + total) % 2 === 1) {
        return 0;
    }

    const s1 = (target + total) / 2;
    let dp = new Array(s1 + 1).fill(0);
    dp[0] = 1;

    dfs(nums, 0, s1, dp);
    return dp[s1];
};

function dfs(nums, idx, target, dp) {
    if (idx === nums.length) {
        return;
    }

    for (let n = target; n >= nums[idx]; n--) {
        dp[n] = dp[n] + dp[n - nums[idx]];
    }

    dfs(nums, idx + 1, target, dp);
}