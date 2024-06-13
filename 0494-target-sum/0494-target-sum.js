/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var findTargetSumWays = function(nums, target) {
    const idx = nums.length - 1;
    return dfs(nums, 0, target, idx);
};

function dfs(nums, curr_sum, target, idx) {
    if (idx < 0 && curr_sum === target) {
        return 1;
    }

    if (idx < 0) {
        return 0;
    }

    let pos = dfs(nums, curr_sum + nums[idx], target, idx - 1);
    let neg = dfs(nums, curr_sum - nums[idx], target, idx - 1);

    return pos + neg;
}