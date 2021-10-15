package api;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){

    }
    public ListNode (int val){
        this.val=val;
    }

    public static ListNode buildList(int arr[]){
        ListNode head=new ListNode(arr[0]);
        ListNode last=head;
        for(int i=1;i<arr.length;i++){
            ListNode node =new ListNode(arr[i]);
            last.next=node;
            last=node;
        }
        return head;
    }
    public static void printList(ListNode head){
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.val+"->");
            cur=cur.next;
        }
    }
}
