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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a, b;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    //反转 a 到 b 之间的结点只要更改函数签名，把null改成b
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

//反转以a为头结点的链表
//    ListNode reverse(ListNode a){
//        ListNode pre,cur,nxt;
//        pre = null;cur = a;nxt = a;
//        while(cur!=null){
//            nxt = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = nxt;
//        }
//        return pre;
//    }
}