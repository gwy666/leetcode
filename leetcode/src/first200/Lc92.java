package first200;

import api.ListNode;
import org.junit.Test;

public class Lc92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        while(--left!=0){
            pre=pre.next;
            cur=cur.next;
            right--;
        }
        if(right==1){
            return head;
        }
        ListNode leftPre=pre;
        ListNode node=cur;
        while(right--!=0){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        leftPre.next=pre;
        node.next=cur;
        return dummy.next;
    }
    @Test
    public void test(){
        int arr[]=new int[]{1,2,3,4,5};
        ListNode head=ListNode.buildList(arr);
        ListNode newHead=reverseBetween(head,1,2);
        ListNode.printList(newHead);

    }
}
