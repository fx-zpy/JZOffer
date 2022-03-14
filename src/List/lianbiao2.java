package List;

import java.util.Stack;

/**
 * JZ24 反转链表
 */
public class lianbiao2 {


    public ListNode ReverseList(ListNode head) {

        Stack<ListNode> ob= new Stack<>();
        if(head==null){return null;}
        while (head!=null){
            ob.push(head);
            head=head.next;
        }
        ListNode a=null;
        while (ob.isEmpty()){
            a=ob.pop();
            a=a.next;
        }

        return a;

    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

