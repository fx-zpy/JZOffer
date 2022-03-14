package List;

/**
 * JZ22 链表中倒数最后k个结点
 */
public class lianbiao6 {


    public ListNode FindKthToTail (ListNode pHead, int k) {
        /**
         * 使用栈来实现
         */

//        if (pHead == null || k == 0){
//            return null;
//        }
//        Stack<ListNode> stack = new Stack<>();
//        //链表节点压栈
//        while (pHead != null) {
//            stack.push(pHead);
//            pHead = pHead.next;
//        }
//        // 判断栈的元素是否小于k
//        if (stack.size() < k){
//            return null;
//        }
//        //在出栈串成新的链表
//        ListNode firstNode = stack.pop();
//        while (--k > 0) {
//            // 将出栈的元素重新连接成为链表
//            ListNode temp = stack.pop();
//            temp.next = firstNode;
//            firstNode = temp;
//        }
//        return firstNode;
        /**
         * 使用快慢指针
         */
        ListNode fast=pHead;
        ListNode slow=pHead;
        for (int i = 0; i < k; i++) {
            if(fast==null){
                return null;
            }
            fast=fast.next;

        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;

    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

