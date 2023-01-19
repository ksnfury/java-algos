package algorithms.medium;

import java.util.*;

/* https://leetcode.com/problems/top-k-frequent-elements/
 *
 * 347. Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



    Example 1:

    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]
    Example 2:

    Input: nums = [1], k = 1
    Output: [1]


    Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.

    Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 * */

public class LeetCode347TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) + 1);
            } else
                map.put(curr, 1);
        }

        LinkedHashMap<Integer, Integer> sortedMap = mapSortedAsPerValues(map);
        int[] retArr = new int[k];
        List<Integer> keys = new ArrayList<Integer>(sortedMap.keySet());

        for (int j = 0; j < k; j++) {
            retArr[j] = keys.get(j);
        }

        return retArr;
    }

    private LinkedHashMap<Integer, Integer> mapSortedAsPerValues(
        Map<Integer, Integer> unsortedMap) {
        List<Map.Entry<Integer, Integer>> unsortedListOfMapEntries = new LinkedList<>();
        unsortedListOfMapEntries.addAll(unsortedMap.entrySet());

        // sort the values
        Collections.sort(unsortedListOfMapEntries,
            (entryOne, entryTwo) -> entryTwo.getValue()
                .compareTo(entryOne.getValue()));

        // try doing it java 8 way as well
        LinkedHashMap<Integer, Integer> retMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entrySet : unsortedListOfMapEntries) {
            retMap.put(entrySet.getKey(), entrySet.getValue());
        }

        return retMap;
    }

    public static void main(String[] args) {
        LeetCode347TopKFrequentElements topKFrequentElements = new LeetCode347TopKFrequentElements();
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(new int[] { 4, 1, -1, 2, -1, 2, 3 },
            2)));
    }
}
