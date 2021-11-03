package algorithms.medium;
/*
        Given an integer array nums, return an array answer such that answer[i] is equal to the
        product of all the elements of nums except nums[i].

        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

        You must write an algorithm that runs in O(n) time and without using the division
        operation.

        Example 1:
        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]
        Example 2:

        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]


        Constraints:

        2 <= nums.length <= 10^5
        -30 <= nums[i] <= 30
        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


        Follow up: Can you solve the problem in O(1) extra space complexity?
        (The output array does not count as extra space for space complexity analysis.)
 */


import java.util.Arrays;

public class LeetCode238ProductOfArrayExceptSelf {


    public static void main(String[] args) {
        LeetCode238ProductOfArrayExceptSelfLeetcodeSol productOfArrayExceptSelfLeetcodeSol = new LeetCode238ProductOfArrayExceptSelfLeetcodeSol();
        System.out.println(Arrays.toString(productOfArrayExceptSelfLeetcodeSol.productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public int[] productExceptSelf(int[] nums) {

        // answer array
        int[] answer = new int[nums.length];

        answer[0] = 1;
        //[1,0,0,0]

        // fill answers array with product of all
        // elements to the left of it
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // for the input [1, 2, 3, 4]
        // answer  = [1,  1,  2, 6]
        int R = 1;

        // repeat the above process in reverse
        for (int j = answer.length - 1; j >= 0; j--) {
            // [ 1, 1, 2, 6]
            answer[j] = answer[j] * R;
            R = R * nums[j];
        }

        return answer;
    }

}
