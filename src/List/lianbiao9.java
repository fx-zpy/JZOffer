package List;



/**
 * JZ18 删除链表的节点
 */
public class lianbiao9 {

    public ListNode deleteNode (ListNode head, int val) {
        ListNode a=new ListNode(-1);
        a.next=head;
        ListNode b=a;
        while(b.next!=null){
            if(b.next.val==val){
                b.next=b.next.next;
                break;
            }
            b=b.next;
        }
        return a.next;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

