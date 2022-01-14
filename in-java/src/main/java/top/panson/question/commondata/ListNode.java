package top.panson.question.commondata;



/**
 * @create 2022-01-14 00:04
 * @Author: Panson
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
