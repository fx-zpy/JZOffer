package QueueAndStack;



import java.util.Stack;

/**
 * JZ31 栈的压入、弹出序列
 */
public class QAS3 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {

        Stack<Integer> stack = new Stack();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            // 若stack的顶部数据与popa出栈数字相同，则数据出栈
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
