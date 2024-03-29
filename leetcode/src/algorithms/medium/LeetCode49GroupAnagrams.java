package algorithms.medium;

import java.util.*;

/*

    https://leetcode.com/problems/group-anagrams/

    49. Group Anagrams

    Given an array of strings strs, group the anagrams together. You can return the answer in any order.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.

    Example 1:

    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    Example 2:

    Input: strs = [""]
    Output: [[""]]
    Example 3:

    Input: strs = ["a"]
    Output: [["a"]]


    Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.
 */


public class LeetCode49GroupAnagrams {

    public static void main(String[] args) {
        LeetCode49GroupAnagrams groupAnagrams = new LeetCode49GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> returnList = new ArrayList<>();
        if (strs == null || strs.length == 0){
            return returnList;
        }
        Map<String, List<String>> stringVsAliases = new HashMap<>();
        for (String s : strs){
            String sortedString = sortString(s);
            if (stringVsAliases.containsKey(sortedString)){
                List<String> aliases = stringVsAliases.get(sortedString);
                aliases.add(s);
            }
            else {
                List<String> aliases = new ArrayList<>();
                aliases.add(s);
                stringVsAliases.put(sortedString, aliases);
            }
        }

        for (List<String> aliases : stringVsAliases.values()){
            returnList.add(aliases);
        }


        return returnList;
    }

    private String sortString(String s1){
        if (s1 == null ){
            return null;
        }
        else if (s1 == ""){
            return "";
        }
        char[] charArrays1 = s1.toCharArray();
        Arrays.sort(charArrays1);
        return new String(charArrays1);
    }

}
