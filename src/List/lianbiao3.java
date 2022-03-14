package List;

import java.util.LinkedList;
import java.util.Queue;

/**
 * JZ25 合并两个排序的链表
 */
public class lianbiao3 {


    public ListNode Merge(ListNode list1,ListNode list2) {

        Queue<ListNode> queue=new LinkedList();
        while(list1!=null&&list2!=null){
            if(list1.val< list2.val){
                queue.offer(list1);
                list1=list1.next;
            }else{
                queue.offer(list2);
                list2=list2.next;
            }
        }
        while(list1!=null){
            queue.offer(list1);
            list1=list1.next;
        }
        while(list2!=null){
            queue.offer(list2);
            list2=list2.next;
        }

        if(queue.isEmpty()){
            return null;
        }
        ListNode a=queue.poll();
        ListNode b=a;
        while(!queue.isEmpty()){
            ListNode c=queue.poll();
            a.next=c;
            a=a.next;
        }
        return b;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

