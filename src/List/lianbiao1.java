package List;

import java.util.ArrayList;

/**
 * JZ6 从尾到头打印链表
 */
public class lianbiao1 {
    ArrayList<Integer> list = new ArrayList();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            // 递归到最后一个链表结点
            printListFromTailToHead(listNode.next);
            // 依次将链表结点元素存入列表
            list.add(listNode.val);
        }
        return list;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

