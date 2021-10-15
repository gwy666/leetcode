package hot100;

import api.ListNode;

public class Lc21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return l1==null?l2:l1;
        }
        ListNode res=null;
        ListNode next=null;
        if(l1.val<l2.val){
            res=l1;
            next=mergeTwoLists(l1.next,l2);
        }
        else{
            res=l2;
            next=mergeTwoLists(l1,l2.next);
        }

        res.next=next;
        return res;
    }
}
