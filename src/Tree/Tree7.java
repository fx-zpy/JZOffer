package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * JZ32 从上往下打印二叉树
 */

public class Tree7 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> arr = new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList();
        TreeNode a=root;
        if(root==null){
            return arr;
        }
        queue.offer(a);
        while(!queue.isEmpty()){
            a=queue.poll();
            arr.add(a.val);
            if(a.left!=null){
                queue.offer(a.left);
            }
            if(a.right!=null){
                queue.offer(a.right);
            }
        }
        return arr;
    }

}
