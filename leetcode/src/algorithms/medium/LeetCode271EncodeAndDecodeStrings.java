package algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/*  https://leetcode.com/problems/encode-and-decode-strings/description/
    271. Encode and Decode Strings

    Design an algorithm to encode a list of strings to a string.
    The encoded string is then sent over the network and is decoded back to the original list of strings.

    Machine 1 (sender) has the function:

    string encode(vector<string> strs) {
    // ... your code
    return encoded_string;
    }

    Machine 2 (receiver) has the function:
    vector<string> decode(string s) {
    //... your code
    return strs;
    }

    So Machine 1 does:

    string encoded_string = encode(strs);
    and Machine 2 does:

    vector<string> strs2 = decode(encoded_string);
    strs2 in Machine 2 should be the same as strs in Machine 1.

    Implement the encode and decode methods.

    You are not allowed to solve the problem using any serialize methods (such as eval).

    Example 1:

    Input: dummy_input = ["Hello","World"]
    Output: ["Hello","World"]
    Explanation:
    Machine 1:
    Codec encoder = new Codec();
    String msg = encoder.encode(strs);
    Machine 1 ---msg---> Machine 2

    Machine 2:
    Codec decoder = new Codec();
    String[] strs = decoder.decode(msg);
    Example 2:

    Input: dummy_input = [""]
    Output: [""]


    Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] contains any possible characters out of 256 valid ASCII characters.
*/

public class LeetCode271EncodeAndDecodeStrings {

    public static void main(String[] args) {
        String a = "hello";
        String b = "world";
        List<String> strings = new ArrayList<>();
        strings.add(a);
        strings.add(b);
        LeetCode271EncodeAndDecodeStrings p = new LeetCode271EncodeAndDecodeStrings();
        String encodedString = p.encode(strings);
        List<String> decodedStrings = p.decode(encodedString);
        System.out.println(decodedStrings);
    }

    public List<String> decode(String encodedString) {
        int i = 0;
        int n = encodedString.length();
        List<String> decodedStrings = new ArrayList<>();
        while (i < n) {
            int length = getLengthOfStringAhead(
                encodedString.substring(i, i + 4));
            i += 4;
            decodedStrings.add(encodedString.substring(i, i + length));
            i += length;
        }
        return decodedStrings;
    }

    private int getLengthOfStringAhead(String s) {
        int result = 0;
        for (char b : s.toCharArray())
            result = (result << 8) + (int) b;
        return result;
    }

    public String encode(List<String> strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(getBytesForString(s));
            sb.append(s);
        }
        return sb.toString();

    }

    private String getBytesForString(String s) {
        char[] bytes = new char[4];
        for (int j = 3; j > -1; --j) {
            int x = s.length();
            for (int i = 3; i > -1; --i) {
                bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
            }

        }

        return new String(bytes);
    }

}
