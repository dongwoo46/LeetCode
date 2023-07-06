class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        total = 0
        end = 0
        min_len = 1e9

        for start in range(len(nums)):


            while total<target and end<len(nums):
                total += nums[end]
                end+=1
            if total >= target:
                min_len = min((end-start),min_len)
            total -= nums[start]
        if min_len == 1e9:
            return 0
        return min_len