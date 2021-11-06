package algorithms.medium;

/*  Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
    and return the product.

        It is guaranteed that the answer will fit in a 32-bit integer.

        A subarray is a contiguous subsequence of the array.

        Example 1:
        Input: nums = [2,3,-2,4]
        Output: 6
        Explanation: [2,3] has the largest product 6.
        Example 2:

        Input: nums = [-2,0,-1]
        Output: 0
        Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


        Constraints:

        1 <= nums.length <= 2 * 10^4
        -10 <= nums[i] <= 10
        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class LeetCode152MaximumProductSubarray {

    public static void main(String[] args) {
        LeetCode152MaximumProductSubarray maximumProductSubarray = new LeetCode152MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maximumProductSubarray(new int[]{-4, 2, 4, 0, -3, 2, 5}));
    }

    private int maximumProductSubarray(int[] arr) {
        // the product of an array will always be product of all numbers given all are positive integers
        // problem occurs when we face 0s and negative integers

        // with 0s we cannot consider that part of the array provided any one of the left/right are
        // positive

        // with negative integers, we're forced to look for another negative


        int currMax = arr[0];
        int currMin = arr[0];
        int result = currMax;

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int tempMax = Math.max(curr, Math.max(curr * currMax, curr * currMin));
            currMin = Math.min(curr, Math.min(curr * currMin, curr * currMax));
            currMax = tempMax;
            result = Math.max(result, currMax);
        }

        return result;
    }


}
