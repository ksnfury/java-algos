package algorithms.medium;

/*  https://leetcode.com/problems/linked-list-cycle-ii/description/

    Linked List Cycle II
    Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

    There is a cycle in a linked list if there is some node in the list that can be reached again by
    continuously following the next pointer. Internally, pos is used to denote the index of the node
    that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos
    is not passed as a parameter.

    Do not modify the linked list.

    Example 1:

    Input: head = [3,2,0,-4], pos = 1
    Output: tail connects to node index 1
    Explanation: There is a cycle in the linked list, where tail connects to the second node.
    Example 2:

    Input: head = [1,2], pos = 0
    Output: tail connects to node index 0
    Explanation: There is a cycle in the linked list, where tail connects to the first node.
    Example 3:

    Input: head = [1], pos = -1
    Output: no cycle
    Explanation: There is no cycle in the linked list.

    Constraints:

    The number of the nodes in the list is in the range [0, 104].
    -105 <= Node.val <= 105
    pos is -1 or a valid index in the linked-list.


    Follow up: Can you solve it using O(1) (i.e. constant) memory? */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode142LinkedListCycleTwo {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override public String toString() {
            return "ListNode{" + "val=" + val + '}';
        }
    }

    public static void main(String[] args) {
        /*ListNode head = new ListNode(3);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(0);
        ListNode three = new ListNode(4);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = one;*/



      /*  ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        head.next = one;
        one.next = head;*/

        // [-1,-7,7,-4,19,6,-9,-5,-2,-5]
        ListNode head = new ListNode(-1);
        ListNode one = new ListNode(-7);
        ListNode two = new ListNode(7);
        ListNode three = new ListNode(-4);
        ListNode four = new ListNode(19);
        ListNode five = new ListNode(6);
        ListNode six = new ListNode(-9);
        ListNode seven = new ListNode(-5);
        ListNode eight = new ListNode(-2);
        ListNode nine = new ListNode(-5);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = six;

        LeetCode142LinkedListCycleTwo linkedListCycleTwo = new LeetCode142LinkedListCycleTwo();
        System.out.println(linkedListCycleTwo.detectCycleBetter(head));
    }

    public ListNode detectCycleOne(ListNode head) {
        Set<ListNode> seenNode = new HashSet<>();

        if (head == null) return null;

        ListNode curr = head;
        while (curr != null && !seenNode.contains(curr)){
            seenNode.add(curr);
            curr = curr.next;
        }

        return curr != null ? curr : null;
    }

    public ListNode detectCycleBetter(ListNode head) {

        if (head == null || head.next == null || head.next.next == null){
            return null;
        }

        ListNode tortoise = head.next;
        ListNode hare = head.next.next;

        while (tortoise != null && hare != null && tortoise != hare){
            tortoise = tortoise.next;
            if (tortoise ==null || hare.next == null){
                return null;
            }
            hare = hare.next.next;
        }

        if (tortoise == null || hare == null){
            return null;
        }

        // tortoise == hare here
        tortoise = head;

        while (tortoise != hare ){
            tortoise = tortoise.next;
            hare = hare.next;
        }

        return hare;
    }


}
