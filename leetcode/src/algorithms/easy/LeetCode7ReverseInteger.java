package algorithms.easy;

import java.util.Arrays;

/*Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



    Example 1:

    Input: x = 123
    Output: 321
    Example 2:

    Input: x = -123
    Output: -321
    Example 3:

    Input: x = 120
    Output: 21
    Example 4:

    Input: x = 0
    Output: 0


    Constraints:

    -2^31 <= x <= 2^31 - 1*/
public class LeetCode7ReverseInteger {

    public static void main(String[] args) {
        LeetCode7ReverseInteger reverseInteger = new LeetCode7ReverseInteger();
        System.out.println(reverseInteger.reverse(1534236469));
    }

    public int reverse(int x) {
        // boundary condition
        if (x <= Integer.MIN_VALUE || x > Integer.MAX_VALUE || x == 0) {
            return 0;
        }
        if (x == Math.abs(x)) {
            return reversedInteger(String.valueOf(x));
        } else
            return -1 * reversedInteger(String.valueOf(Math.abs(x)));
    }

    private int reversedInteger(String x) {
        try {
            return Integer.valueOf(new StringBuilder(x).reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
