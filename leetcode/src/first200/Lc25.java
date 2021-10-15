package first200;

import api.ListNode;
import org.junit.Test;

public class Lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur=head;
        int temp=k;
        while(--temp!=0&&cur!=null){
            cur=cur.next;
        }
        if(cur==null)return head;
        ListNode node=cur.next;
        cur.next=null;
        ListNode newHead=reverseKth(head,k);
        ListNode next=reverseKGroup(node,k);
        head.next=next;
        return newHead;
    }
    public ListNode reverseKth(ListNode head,int k){
       ListNode cur=head;
       ListNode pre=null;
       while(k--!=0){
           ListNode next=cur.next;
           cur.next=pre;
           pre=cur;
           cur=next;
       }
       head.next=cur;
       return pre;
    }
    @Test
    public void test(){
        ListNode head=ListNode.buildList(new int[]{1,2,3,4,5,6,7});
        int k=3;
        ListNode res=reverseKGroup(head,k);
        ListNode.printList(res);
    }
}
