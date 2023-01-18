package algorithms.easy;

/*  Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.

        Example 1:

        Input: nums = [1,2,3,1]
        Output: true
        Example 2:

        Input: nums = [1,2,3,4]
        Output: false
        Example 3:

        Input: nums = [1,1,1,3,3,4,3,2,4,2]
        Output: true


        Constraints:

        1 <= nums.length <= 10^5
        -109 <= nums[i] <= 10^9*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode217ContainsDuplicate {

    public static void main(String[] args) {
        LeetCode217ContainsDuplicate containsDuplicate = new LeetCode217ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,2,3,4}));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        return Arrays.stream(nums).anyMatch(num -> !numSet.add(num));
    }
}
