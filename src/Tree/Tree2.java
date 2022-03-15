package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * JZ77 按之字形顺序打印二叉树
 */

public class Tree2 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        Deque deque=new LinkedList();
        ArrayList arr = new ArrayList<>();
        if(pRoot!=null){
            deque.add(pRoot);
        }
        while(!deque.isEmpty()){

            /**
             * 从左到右
             */
            ArrayList templ = new ArrayList<>();
            for (int i = deque.size(); i >0 ; i--) {
                TreeNode tn= (TreeNode) deque.removeFirst();
                templ.add(tn.val);
                if(tn.left!=null){
                    deque.addLast(tn.left);

                }
                if(tn.right!=null){
                    deque.addLast(tn.right);

                }
            }
            arr.add(templ);
            if(deque.isEmpty()){
                break;
            }
            /**
             * 从右到左
             */
            ArrayList tempr = new ArrayList<>();
            for (int i = deque.size(); i >0 ; i--) {
                TreeNode tn= (TreeNode) deque.removeLast();
                tempr.add(tn.val);
                if(tn.right!=null){
                    deque.addFirst(tn.right);

                }
                if(tn.left!=null){
                    deque.addFirst(tn.left);

                }
            }
            arr.add(tempr);
        }

        return arr;

    }

}
