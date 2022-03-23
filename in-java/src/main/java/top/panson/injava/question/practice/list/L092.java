package top.panson.injava.question.practice.list;

import top.panson.injava.question.commondata.ListNode;

/**
 * @create 2022-03-23 22:15
 * @Author: Panson
 */
public class L092 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode p = dummy;
            ListNode q = head;

            for(int i = 0; i < left - 1; i++) {
                p = p.next;
                q = q.next;
            }

            for(int i = 0; i < right - left; i++) {
                ListNode removed = q.next;
                q.next = removed.next;
                removed.next = p.next;
                p.next = removed;

            }
            return dummy.next;
        }
    }
}
