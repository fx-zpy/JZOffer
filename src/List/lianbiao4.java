package List;

/**
 * JZ52 两个链表的第一个公共结点
 */
public class lianbiao4 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode a=pHead2;
        while(pHead1!=null){
            pHead2=a;
            while(pHead2!=null){
                if(pHead1==pHead2){
                    return pHead1;
                }
                pHead2=pHead2.next;
            }
            pHead1=pHead1.next;
        }
        return null;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

