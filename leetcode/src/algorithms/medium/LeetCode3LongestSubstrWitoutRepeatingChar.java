package algorithms.medium;

/*https://leetcode.com/problems/longest-substring-without-repeating-characters/

    Given a string s,find the length of the longest substring without repeating characters.

    Example 1:

    Input:s="abcabcbb"
    Output:3 Explanation:The answer is"abc",with the length of 3.
    Example 2:

    Input:s="bbbbb"
    Output:1 Explanation:The answer is"b",with the length of 1.
    Example 3:

    Input:s="pwwkew"
    Output:3 Explanation:The answer is"wke",with the length of 3.
    Notice that the answer must be a substring,"pwke"is a subsequence and not a substring.
    Example 4:

    Input:s=""
    Output:0*/

import java.util.HashMap;
import java.util.Map;

public class LeetCode3LongestSubstrWitoutRepeatingChar {

    public static void main(String[] args) {
        LeetCode3LongestSubstrWitoutRepeatingChar problemThree = new LeetCode3LongestSubstrWitoutRepeatingChar();
        System.out.println(problemThree.lengthOfLongestSubstring("abcdabcdebb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Map<Character, Integer> charVsPosition = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char curr = s.charAt(j);

            if (charVsPosition.containsKey(curr)){
                // correct the position of i
                // to the max between current position of i
                // and the current position of the character
                i = Math.max(charVsPosition.get(curr), i);
            }

            answer = Math.max(answer, j-i+1);
            charVsPosition.put(curr, j+1);
        }
        return answer;
    }
}
