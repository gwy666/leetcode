package first200;

import api.ListNode;
import api.TreeNode;

public class Lc109 {
    public TreeNode sortedListToBST(ListNode head) {

        return recur(head,null);
    }

    public TreeNode recur(ListNode head,ListNode tail){
        if(head==tail){
            return null;
        }
        ListNode low=head;
        ListNode fast=head;
        while(fast!=tail&&fast.next!=tail){
            low=low.next;
            fast=fast.next.next;
        }
        TreeNode root=new TreeNode(low.val);
        root.left=recur(head,low);
        root.right=recur(low.next,tail);
        return root;
    }
}
