package QueueAndStack;

import java.util.Stack;

/**
 * JZ30 包含min函数的栈
 */
public class QAS2 {
    // 存储最小元素数组
    //创建原栈及辅助栈
    private Stack<Integer> originalData = new Stack<Integer>();
    private Stack<Integer> minData = new Stack<Integer>();

    public void push(int node) {
        originalData.push(node);
        if(minData.isEmpty() || node <= minData.peek()){ //
            minData.push(node);
        }else{
            minData.push(minData.peek());//当压入的结点大时，则每次都压入min栈顶的值。
        }
    }

    public void pop() {
        originalData.pop();//出栈时，min栈和data栈均出栈
        minData.pop();
    }

    public int top() {
        return originalData.peek();
    }

    public int min() {
        return minData.peek();
    }
}
