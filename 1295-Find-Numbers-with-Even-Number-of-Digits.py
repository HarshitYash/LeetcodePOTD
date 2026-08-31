class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        count = 0
        for i in range(len(nums)):
            c = int(math.log10(nums[i])) + 1
            if c % 2 == 0:
                count += 1
        return count