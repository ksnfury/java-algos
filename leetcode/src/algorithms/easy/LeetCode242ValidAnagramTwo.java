package algorithms.easy;


import java.util.Arrays;

public class LeetCode242ValidAnagramTwo {

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

        if (s == null || t == null || s.length() != t.length()){
            return Boolean.FALSE;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for (int i = 0; i < sArray.length; i++){
            Character sChar = sArray[i];
            if (!sChar.equals(tArray[i])){
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        LeetCode242ValidAnagramTwo validAnagram = new LeetCode242ValidAnagramTwo();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
    }
}
