package algorithms.easy;

public class LeetCode7ReverseIntegerOptimum {
    public static void main(String[] args) {
        LeetCode7ReverseIntegerOptimum reverseIntegerOptimum = new LeetCode7ReverseIntegerOptimum();
        System.out.println(reverseIntegerOptimum.reverse(-123));
    }

    public int reverse(int x) {

        // reversed number
        int reversed = 0;
        while (x != 0) {
            // last digit
            int remainder = x % 10;
            // check before reversing for overflow
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && remainder > 7))
                return 0;
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && remainder > 8))
                return 0;
            x = x/10;
            // reversed number
            reversed = remainder + reversed * 10;
        }

        return reversed;
    }
}
