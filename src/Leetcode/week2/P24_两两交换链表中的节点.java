package Leetcode.week2;

/**
 * @author: CaiSongZhi
 * @date: 2022/3/3 9:01
 * @project: Leetcode.week2
 * @content: https://leetcode-cn.com/problems/swap-nodes-in-pairs/ 中等
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class P24_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = head, b = head.next, p = dummy;
        while(b != null){
            ListNode t = b.next;
            b.next = a;
            a.next = t;
            p.next = b;
            p = a;
            a = a.next;
            if(a != null) b = a.next;
            else break;
        }
        return dummy.next;
    }
}