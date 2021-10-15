package hot100;

import api.ListNode;

import java.util.Stack;

public class Lc19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        ListNode low=head;
        ListNode newHead=new ListNode();
        newHead.next=head;
        ListNode pre=newHead;

        while(n--!=0){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            pre=low;
            low=low.next;
        }
        pre.next=low.next;
        return newHead.next;

    }
}
