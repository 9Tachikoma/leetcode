/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //为了防止出现空指针的情况，比如说链表总共有 5 个节点，题目就让你删除倒数第 5 个节点，也就是第一个节点，那按照算法逻辑，应该首先找到倒数第 6 个节点。但第一个节点前面已经没有节点了，这就会出错。
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //删除第n个，要找到倒数第n+1个节点
        ListNode x = findFromEnd(dummy, n + 1);
        x.next = x.next.next;
        return dummy.next;
    }


    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        //先走k步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        //p1剩下的步数走完，p2同时前进，p2就走到了倒数第k个节点
        ListNode p2 = head;
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }
}