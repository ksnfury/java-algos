package algorithms.medium;

/*
    https://leetcode.com/problems/container-with-most-water/submissions/

    11. Container With Most Water

    You are given an integer array height of length n.
    There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.



    Example 1:


    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
     In this case, the max area of water (blue section) the container can contain is 49.
    Example 2:

    Input: height = [1,1]
    Output: 1


    Constraints:

    n == height.length
    2 <= n <= 105*/

public class LeetCode11ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        int currMax = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (left == 0 || (left >= 1 && height[left] > height[left-1])){
                currMax = (right - left) * Math.min(height[right], height[left]);
                max = Math.max(currMax, max);
            }
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;

    }

    public static void main(String[] args) {
        LeetCode11ContainerWithMostWater containerWithMostWater = new LeetCode11ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(
            new int[] { 2, 3, 4, 5, 18, 17, 6 }));
    }
}
