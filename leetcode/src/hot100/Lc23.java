package hot100;

import api.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc23 {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode lists[],int left,int right){
        if(left==right){
            return lists[left];
        }
        if(left+1==right){
            return mergeTwoLists(lists[left],lists[right]);
        }
        int mid=(left+right)/2;
        ListNode l1=merge(lists,left,mid-1);
        ListNode l2=merge(lists,mid,right);
        return mergeTwoLists(l1,l2);
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode res=new ListNode();
        ListNode cur=res;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }
            else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=l1==null?l2:l1;
        return res.next;
    }
}
