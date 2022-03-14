package List;

/**
 * JZ23 链表中环的入口结点
 */
public class lianbiao5 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {


/**
 * 第一次尝试
 */
//        int flag=0;
//        int k=0;
//        while(pHead!=null&&k<=10000){
//            ListNode a=pHead.next;
//            flag=0;
//            while(a!=null&&flag<=10000){
//                if(pHead==a.next){
//                    return pHead;
//                }else if(a.next==pHead.next){
//                    return a.next;
//                }
//                flag++;
//                a=a.next;
//            }
//            k++;
//            pHead=pHead.next;
//        }
//        return null;
        /**
         * 使用HashSet来写
         * 时间复杂度O(n)，空间复杂度O(n)
         */
//        HashSet<ListNode> hashSet = new HashSet();
//        while(pHead!=null){
//            if(hashSet.contains(pHead)){
//                return pHead;
//            }
//            hashSet.add(pHead);
//            pHead=pHead.next;
//        }
//        return null;

        /**
         * 使用快慢指针
         * 时间复杂度O(n)，空间复杂度O(1)
         */
        if(pHead == null) {return null;}
        // 定义快慢指针
        ListNode slow = pHead;
        ListNode fast = pHead;
        while(fast != null && fast.next != null){
            // 快指针是满指针的两倍速度
            fast = fast.next.next;
            slow = slow.next;
            // 记录快慢指针第一次相遇的结点
            if(slow == fast) break;
        }
        // 若是快指针指向null，则不存在环
        if(fast == null || fast.next == null) return null;
        // 重新指向链表头部
        fast = pHead;
        // 与第一次相遇的结点相同速度出发，相遇结点为入口结点
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

