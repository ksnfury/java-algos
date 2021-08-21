package algorithms.medium;

/*Given a string s, return the longest palindromic substring in s.

    Example 1:

    Input: s = "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
    Example 2:

    Input: s = "cbbd"
    Output: "bb"
    Example 3:

    Input: s = "a"
    Output: "a"
    Example 4:

    Input: s = "ac"
    Output: "a"


    Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters.*/
public class LeetCode5LongestPalindromicSubstring {

    public static void main(String[] args) {
        LeetCode5LongestPalindromicSubstring longestPalindromicSubstring = new LeetCode5LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("abcbade"));
    }

    public String longestPalindrome(String s) {
        // maintain 2 integers for start and end of the longest palindrome
        int start = 0;
        int end = 0;
        // iterate over the string till the end
        for (int i = 0; i < s.length(); i++) {
            // first expand around the ith character
            // i.e. ith character is the centre
            int longestAroundEye = expandAroundCenter(s, i, i);
            // then expand around the i, i+1 th character
            // i.e. i and (i+1)th character are the combined centre
            int longestAroundEyeAndEyePlusOne = expandAroundCenter(s, i, i + 1);
            // current maximum palindrome
            int currMax = Math.max(longestAroundEye, longestAroundEyeAndEyePlusOne);

            // if this is the longest palindrome till now,
            // reassign start = beginning of palindrome i.e. i - (currMax - 1)/2
            // reassign end = end of palindrome i.e. i + currMax / 2
            if (currMax > (end - start)) {
                start = i - (currMax - 1) / 2;
                end = i + currMax / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // right and left have already been
        // pushed one to the left and right
        // subtract 1
        return right - left - 1;
    }
}
