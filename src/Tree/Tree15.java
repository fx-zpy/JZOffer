package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

/**
 * JZ78 把二叉树打印成多行
 */

public class Tree15 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> arrs=new ArrayList<>();
        HashMap<TreeNode,Integer> hashMap=new HashMap<>();
        if(pRoot==null){
            return arrs;
        }
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.addFirst(pRoot);
        hashMap.put(pRoot,0);
        while(!deque.isEmpty()){
            pRoot=deque.pollLast();
            int deep=hashMap.get(pRoot);
            if(pRoot.left!=null){
                deque.addFirst(pRoot.left);
                hashMap.put(pRoot.left,deep+1);
            }
            if(pRoot.right!=null){
                deque.addFirst(pRoot.right);
                hashMap.put(pRoot.right,deep+1);
            }
            if(arrs.size()<=deep){
                ArrayList<Integer> arr=new ArrayList<>();
                arr.add(pRoot.val);
                arrs.add(arr);
            }
            else{
                ArrayList<Integer> arr=arrs.get(deep);
                arr.add(pRoot.val);
            }

        }
        return arrs;
    }

}
