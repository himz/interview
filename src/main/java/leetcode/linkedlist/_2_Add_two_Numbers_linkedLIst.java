package leetcode.linkedlist;

import common.ListNode;

/**
 * 2. Add Two Numbers
 * Medium
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in each linked list is in the range [1, 100].
 *     0 <= Node.val <= 9
 *     It is guaranteed that the list represents a number that does not have leading zeros.
 *
 *     https://leetcode.com/problems/add-two-numbers/
 */
public class _2_Add_two_Numbers_linkedLIst {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0, val = 0,sum = 0;
        while( p != null ||  q != null) {
            int pVal = 0, qVal = 0;
            if(p!= null) {
                pVal = p.val;
            }

            if(q!= null) {
                qVal = q.val;
            }

            sum = pVal + qVal + carry;
            val = sum % 10;
            if(sum != val) {
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode node = new ListNode(val);
            tail.next = node;
            tail = tail.next;
            if(p != null)
                p = p.next;
            if(q != null)
                q = q.next;
        }

        // Both of the lists are null. Handle carry case.

        if(carry == 1) {
            ListNode node = new ListNode(carry);
            tail.next = node;
            tail = tail.next;
        }

        return dummy.next;

    }
}