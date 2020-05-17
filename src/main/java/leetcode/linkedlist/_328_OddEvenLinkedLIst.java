package leetcode.linkedlist;

import common.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 *
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 *
 * Note:
 *
 *     The relative order inside both the even and odd groups should remain as it was in the input.
 *     The first node is considered odd, the second node even and so on ...
 *
 *     https://leetcode.com/problems/odd-even-linked-list/
 */
public class _328_OddEvenLinkedLIst {
    public ListNode oddEvenList(ListNode head) {
        ListNode p = null; // End of odd list
        ListNode q = head; // end of even list

        if(q == null || q.next == null) {
            return head;
        }

        ListNode r = q.next;    // Element to be switched
        p = q;
        q = q.next;
        r = q.next;
        ListNode se = q;  // Start of even list
        while(r != null) {
            // Starting with base case(1,2,3)
            // Swap
            q.next = r.next;
            r.next = se;
            p.next = r;


            // Iterate to next odd item to be put in place.
            p = r;
            q = q.next;
            if(q != null) {
                r = q.next;
            } else {
                r = null;
            }
        }

        return head;
    }
}