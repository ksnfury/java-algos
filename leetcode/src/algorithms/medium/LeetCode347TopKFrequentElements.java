package algorithms.medium;

import java.util.*;

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
