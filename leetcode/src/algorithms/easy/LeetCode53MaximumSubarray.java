package algorithms.easy;

import java.util.Arrays;

public class LeetCode53MaximumSubarray {

    /*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has
    the largest sum and return its sum.

    A subarray is a contiguous part of an array.

    Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    Example 2:

    Input: nums = [1]
    Output: 1
    Example 3:

    Input: nums = [5,4,-1,7,8]
    Output: 23


    Constraints:

    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4


    Follow up: If you have figured out the O(n) solution,
    try coding another solution using the divide and conquer approach, which is more subtle.*/

    public static void main(String[] args) {
        LeetCode53MaximumSubarray maximumSubarray = new LeetCode53MaximumSubarray();
        //System.out.println(maximumSubarray.maxSubArray(new int[]{5, 4, -1, 7, 8}));
        //System.out.println(maximumSubarray.maxSubArray(new int[]{1}));
        //System.out.println(maximumSubarray.maxSubArray(new int[]{4, -1, 2, 1}));
        //System.out.println(maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        //System.out.println(maximumSubarray.maxSubArrayUsingDivideAndConquer(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maximumSubarray.maxSubArrayUsingDivideAndConquer(new int[]{-84,-87,-78,-16,-94,-36,-87,-93,-50,-22,-63,-28,-91,-60,-64,-27,-41,-27,-73,-37,-12,-69,-68,-30,-83,-31,-63,-24,-68,-36,-30,-3,-23,-59,-70,-68,-94,-57,-12,-43,-30,-74,-22,-20,-85,-38,-99,-25,-16,-71,-14,-27,-92,-81,-57,-74,-63,-71,-97,-82,-6,-26,-85,-28,-37,-6,-47,-30,-14,-58,-25,-96,-83,-46,-15,-68,-35,-65,-44,-51,-88,-9,-77,-79,-89,-85,-4,-52,-55,-100,-33,-61,-77,-69,-40,-13,-27,-87,-95,-40}));
    }

    public int maxSubArrayUsingDivideAndConquer(int[] nums) {
        // divide into
        return maxSubArrayWithRange(nums, 0, nums.length - 1);
    }

    // helper method to calculate maximum subarray
    private int maxSubArrayWithRange(int[] nums, int min, int max) {
        if (min > max) {
            return Integer.MIN_VALUE;
        }

        int mid = Math.floorDiv(min + max, 2);

        int maxLeft = 0;
        int curr = 0;
        // find best of left
        for (int i = mid - 1; i >= min; i--) {
            curr += nums[i];
            maxLeft = Math.max(maxLeft, curr);
        }

        curr = 0;
        int maxRight = 0;
        // find best of right
        for (int i = mid + 1; i <= max; i++) {
            curr += nums[i];
            maxRight = Math.max(maxRight, curr);
        }

        // add left and right to mid
        int combinedBest = maxLeft + maxRight + nums[mid];

        // repeat on left
        int bestOfLeft = maxSubArrayWithRange(nums, min, mid - 1);

        // repeat on right
        int bestOfRight = maxSubArrayWithRange(nums, mid + 1, max);

        return Math.max(combinedBest, Math.max(bestOfRight, bestOfLeft));
    }

    public int maxSubArray(int[] nums) {
        int currentSubArraySum = nums[0];
        int maxSubArraySum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // if the current sum is less than with the subsequent number added
            // start with the next number onward
            // else keep adding to current sum
            currentSubArraySum = Math.max(nums[i], currentSubArraySum + nums[i]);
            maxSubArraySum = Math.max(maxSubArraySum, currentSubArraySum);
        }

        return maxSubArraySum;
    }
}
