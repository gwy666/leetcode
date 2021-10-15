package first200;

import api.ListNode;

public class Lc206 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;

        ListNode next=reverseList(head.next);
        next.next=head;
        head.next=null;
        return head;
    }
}
