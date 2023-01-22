package algorithms.easy;

/*  https://leetcode.com/problems/valid-palindrome/

    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.



    Example 1:

    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.
    Example 2:

    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.
    Example 3:

    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.


    Constraints:

    1 <= s.length <= 2 * 105
    s consists only of printable ASCII characters.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode125ValidPalindrome {

    public static void main(String[] args) {
        LeetCode125ValidPalindrome validPalindrome = new LeetCode125ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("Karan naraK"));
    }

    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (char sChar :s.toCharArray()){
            if (Character.isLetterOrDigit(sChar)){
                sb.append(sChar);
            }
        }

        String potentialPalindrome = sb.toString().toLowerCase();
        int lo = 0;
        int hi = sb.length() -1;

        while (lo < hi){
            if (potentialPalindrome.charAt(lo) != potentialPalindrome.charAt(hi)){
                return false;
            }
            lo++;
            hi--;
        }

        return true;

    }

}
