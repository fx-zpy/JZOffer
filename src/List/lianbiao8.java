package List;


/**
 * JZ76 删除链表中重复的结点
 */
public class lianbiao8 {
    public ListNode deleteDuplication(ListNode pHead) {

//        HashSet hashSet = new HashSet();
//        HashSet hs = new HashSet();
//        Queue<ListNode> queue=new LinkedList();
//        if(pHead==null){
//            return null;
//        }
//        hashSet.add(pHead.val);
//        queue.add(pHead);
//        pHead=pHead.next;
//        while(pHead!=null){
//            if(hashSet.contains(pHead.val)){
//                hs.add(pHead.val);
//                pHead=pHead.next;
//                continue;
//            }
//            hashSet.add(pHead.val);
//            queue.add(pHead);
//            pHead=pHead.next;
//        }
//        while(true){
//            ListNode a=queue.poll();
//            while(true){
//                if(queue.isEmpty()){
//                    return null;
//                }
//                if(hashSet.contains(a.val)){
//                    a=queue.poll();
//                    continue;
//                }
//                if(!hashSet.contains(a.val)){
//                    break;
//                }
//            }
//            ListNode b=a;
//            while(!queue.isEmpty()){
//                ListNode temp=queue.poll();
//                if(!hs.contains(temp.val)){
//                    a.next=temp;
//                    a=a.next;
//                }
//
//            }
//            return b;
//        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (pHead != null) {
            // 进入循环时，确保了 pHead 不会与上一节点相同
            if (pHead.next == null || pHead.next.val != pHead.val) {
                tail.next = pHead;
                tail = pHead;
            }
            // 如果 pHead 与下一节点相同，跳过相同节点（到达「连续相同一段」的最后一位）
            while (pHead.next != null && pHead.val == pHead.next.val) {pHead = pHead.next;}
            pHead = pHead.next;
        }
        tail.next = null;
        return dummy.next;

    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

