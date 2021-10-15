package hot100;

import api.ListNode;
import api.TreeNode;
import org.junit.Test;

public class Lc2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry=0;
        ListNode cur1=l1;
        ListNode cur2=l2;
        ListNode res=new ListNode();
        ListNode cur=res;
        while(l1!=null||l2!=null){
            int n=l1==null?0:l1.val;
            int m=l2==null?0:l2.val;
            int newNodeVal=(n+m+carry)%10;
            carry=(n+m+carry)/10;
            ListNode newNode=new ListNode(newNodeVal);
            cur.next=newNode;
            cur=cur.next;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if(carry!=0){
            ListNode tail=new ListNode(1);
            cur.next=tail;
        }
        return res.next;
    }

    @Test
    public void test(){

    }
}
