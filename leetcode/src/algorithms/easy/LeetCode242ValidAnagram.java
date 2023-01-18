package algorithms.easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode242ValidAnagram {

    /*242. Valid Anagram
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.



    Example 1:

    Input: s = "anagram", t = "nagaram"
    Output: true
    Example 2:

    Input: s = "rat", t = "car"
    Output: false

    Constraints:

        1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.


    Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?*/

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return Boolean.FALSE;
        }

        Map<Character, Integer> charVsOccurence = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            if (charVsOccurence.containsKey(sChar)) {
                charVsOccurence.put(sChar, charVsOccurence.get(sChar) + 1);
            } else
                charVsOccurence.put(sChar, 1);
        }

        for (int j = 0; j < t.length(); j++) {
            Character tChar = t.charAt(j);
            if (!charVsOccurence.containsKey(tChar) ){
                return Boolean.FALSE;
            }

            if (charVsOccurence.get(tChar) > 1){
                charVsOccurence.put(tChar, charVsOccurence.get(tChar)-1);
            }
            else if (charVsOccurence.get(tChar) == 1){
                charVsOccurence.remove(tChar);
            }
        }
        return charVsOccurence.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode242ValidAnagram validAnagram = new LeetCode242ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
    }
}
