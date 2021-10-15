package first200;

import api.ListNode;
import org.junit.Test;

public class Lc143 {

    public void reorderList(ListNode head) {
        dfs(head);
    }
    public ListNode dfs(ListNode head){
        if(head.next==null||head.next.next==null){
            return head;
        }
        ListNode cur=head;
        while(cur.next.next!=null){
            cur=cur.next;
        }
        ListNode t=cur.next;
        cur.next=null;
        ListNode temp=head.next;
        head.next=t;
        ListNode next=dfs(temp);
        t.next=next;
        return head;
    }
    @Test
    public void test(){
        int arr[]=new int[]{1,2,3,4,5};
        ListNode head = ListNode.buildList(arr);
        reorderList(head);

    }
}
