package List;

import java.util.HashMap;
import java.util.Map;

/**
 * JZ35 复杂链表的复制
 */
public class lianbiao7 {
    public RandomListNode Clone(RandomListNode pHead) {

        if(pHead == null) {return null;}
        RandomListNode cur = pHead;
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(pHead);



    }
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
