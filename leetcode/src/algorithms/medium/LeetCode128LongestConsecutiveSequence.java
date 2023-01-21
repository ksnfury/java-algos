package algorithms.medium;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode128LongestConsecutiveSequence {

    public int longestConsecutive(int[] numsUnsorted) {

        if (numsUnsorted.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numsUnsorted.length; i++) {
            set.add(numsUnsorted[i]);
        }

        int n = set.size();
        int[] nums = new int[n];

        int k = 0;
        for (int num : set) {
            nums[k++] = num;
        }

        Arrays.sort(nums);

        int max = 1, currMax = 1;
        for (int j = 1; j < nums.length ; j++) {
            if (nums[j] == nums[j - 1] + 1) {
                currMax++;
            } else {
                max = currMax > max ? currMax : max;
                currMax = 1;
            }
        }

        return currMax > max ? currMax: max;

    }

    public static void main(String[] args) {
        LeetCode128LongestConsecutiveSequence longestConsecutiveSequence = new LeetCode128LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(
            new int[] { 9,1,4,7,3,-1,0,5,8,-1,6 }));
    }
}
