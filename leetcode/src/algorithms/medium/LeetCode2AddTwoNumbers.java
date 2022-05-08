package algorithms.medium;


/*
    You are given two non-empty linked lists representing two non-negative integers.
     The digits are stored in reverse order, and each of their nodes contains a single digit.
      Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example 1:

    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.
    Example 2:

    Input: l1 = [0], l2 = [0]
    Output: [0]
    Example 3:

    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]
*/

public class LeetCode2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyNode = new ListNode(0);
        int carry = 0;
        ListNode currNode = dummyNode;
        while (l1 != null || l2 != null) {
            int elOneVal = l1 == null ? 0 : l1.val;
            int elTwoVal = l2 == null ? 0 : l2.val;

            int currSum = elOneVal + elTwoVal + carry;
            carry = currSum / 10;
            currNode.next = new ListNode(currSum % 10);
            currNode = currNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            currNode.next = new ListNode(carry);
        }

        return dummyNode.next;

    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override public String toString() {
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }
    }

    public static void main(String[] args) {
        LeetCode2AddTwoNumbers.ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        LeetCode2AddTwoNumbers.ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        LeetCode2AddTwoNumbers addTwoNumbers = new LeetCode2AddTwoNumbers();
        System.out.println(addTwoNumbers.addTwoNumbers(l1, l2));
    }

}

