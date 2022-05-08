package algorithms.hard;

/*  https://leetcode.com/problems/median-of-two-sorted-arrays
    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

    The overall run time complexity should be O(log (m+n)).

    Example 1:

    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.
    Example 2:

    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    Example 3:

    Input: nums1 = [0,0], nums2 = [0,0]
    Output: 0.00000
    Example 4:

    Input: nums1 = [], nums2 = [1]
    Output: 1.00000
    Example 5:

    Input: nums1 = [2], nums2 = []
    Output: 2.00000


    Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106*/

import java.util.Arrays;

public class LeetCode4MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        LeetCode4MedianOfTwoSortedArrays medianOfTwoSortedArrays = new LeetCode4MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        // 1 ,2  // 3, 4
        // i     // j
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merged[i + j] = nums1[i];
                i++;
            } else {
                merged[i + j] = nums2[j];
                j++;
            }
        }

        if (i == nums1.length) {
            // add all from nums2 into merged
            for (int k = j; k < nums2.length; k++) {
                merged[i+k] = nums2[k];
            }
        } else if (j == nums2.length) {
            // add all from nums1 into merged
            for (int k = i; k < nums1.length; k++) {
                merged[j+k] = nums1[k];
            }
        }

        System.out.println(Arrays.toString(merged));

        // if number of elements is even,
        // get the mean of n/2 and n/2 + 1th elements
        int length = merged.length;
        if (merged.length % 2 == 0 ){
            return (merged[length/2-1] + merged[length/2])/2.0;
        }else {
            // if number of elements is odd
            // return the middle number
            return merged[length/2];
        }
    }
}
