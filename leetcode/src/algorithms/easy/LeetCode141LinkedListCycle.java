package algorithms.easy;

/* https://leetcode.com/problems/linked-list-cycle/

Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by
    continuously following the next pointer. Internally, pos is used to denote the index of the node that
    tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

*/

public class LeetCode141LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(0);
        ListNode three = new ListNode(4);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = one;

        LeetCode141LinkedListCycle linkedListCycle = new LeetCode141LinkedListCycle();
        System.out.println(linkedListCycle.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode tortoise = head.next;
        ListNode hare = head.next.next;

        while (tortoise != null && hare != null && tortoise != hare) {
            tortoise = tortoise.next;
            if (hare.next == null) {
                return false;
            }
            hare = hare.next.next;
        }

        if (tortoise == hare) {
            return true;
        } else
            return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
