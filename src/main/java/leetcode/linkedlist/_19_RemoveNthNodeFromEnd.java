package leetcode.linkedlist;

import common.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * Medium
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Follow up: Could you do this in one pass?
 *
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the list is sz.
 *     1 <= sz <= 30
 *     0 <= Node.val <= 100
 *     1 <= n <= sz
 *
 *     https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class _19_RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode iter = removeNthIterative(head, n);
        ListNode recur = removeNthFromEndRecursive(head, n);

        return recur;
    }
    // Two pointers, tortoise and hare. Using that, we get half len. Now its just a matter of math
    // at max, we iterate n nodes.
    public ListNode removeNthIterative(ListNode head, int n) {
        ListNode t = head, h = head;
        int halfLen = 0;    // floor function
        int len = 0;
        while(true) {
            if(h == null || h.next == null)
                break;
            t = t.next;
            halfLen++;
            h = h.next.next;
            len += 2;
        }

        if(h != null)
            len++;
        //System.out.println(len + "," + halfLen);

        // t points to mid of the list.
        int k = len - n;
        ListNode q = head;
        int count = 0;
        ListNode tail = null;
        if(k <= halfLen) {
            // move q one at a time till we get ans.
            while(count < k) {
                tail = q;
                q = q.next;
                count++;
            }
        } else {
            q = t;
            while(count < (k-halfLen)) {
                tail = q;
                q = q.next;
                count++;
            }
        }

        // node to remove is q.
        if(tail != null)
            tail.next = q.next;
        else
            head = q.next;


        return head;

    }



    int c;

    /**
     * This is more intuitive and simple. Idea is, go to last, if count is n, remove the node
     * return head.
     */
    public ListNode removeNthFromEndRecursive(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        c = 0;
        return remN(head, n, head);
    }

    ListNode remN(ListNode head, int n, ListNode start) {
        if(head == null) {
            return null;
        }

        remN(head.next, n, start);
        if(c++ == n) {
            // next node to be removed.
            head.next = head.next.next;
        }

        if(head == start && c == n) {
            // first node to be deleted
            head = head.next;
        }
        return head;
    }
}