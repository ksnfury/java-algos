package algorithms.easy;

/*  #1 https://leetcode.com/problems/two-sum/

    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]*/

import java.util.HashMap;
import java.util.Map;

public class LeetCode1TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsVsIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numsVsIndices.containsKey(complement)) {
                return new int[] { numsVsIndices.get(complement) , i };
            }
            numsVsIndices.put(nums[i], i);
            // [3,0], [2,1] , [4,
            // send back 1, 2
        }

        return null;
    }

    public static void main(String[] args) {
        LeetCode1TwoSum leetCode1TwoSum = new LeetCode1TwoSum();
        leetCode1TwoSum.twoSum(new int[] { 3, 2, 4 }, 6);
    }
}
