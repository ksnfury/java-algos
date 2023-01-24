package algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15ThreeSum {

    public static void main(String[] args) {
        LeetCode15ThreeSum threeSum = new LeetCode15ThreeSum();
        List<List<Integer>> threeSumList = threeSum.threeSum(
            new int[] { -2, 0, 0, 2, 2 });
        System.out.println(threeSumList);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> retList = new ArrayList<>();

        int i = 0;

        while (i < nums.length - 2) {
            int curr = nums[i];

            if (curr > 0)
                return retList;

            if (i != 0 && nums[i - 1] == nums[i]) {
                i++;
                continue;
            }

            int lo = i + 1;
            int hi = nums.length - 1;

            while (lo < hi) {
                int sum = curr + nums[lo] + nums[hi];
                if (sum == 0) {
                    List<Integer> zeroList = new ArrayList<>();
                    Arrays.asList(new int[] { curr, nums[lo], nums[hi] });
                    while (lo < hi && nums[lo - 1] == nums[lo]) {
                        lo++;
                    }
                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
            i++;
        }
        return retList;
    }

}
