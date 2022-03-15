package Tree;

import java.util.Arrays;
import java.util.HashMap;

/**
 * JZ7 重建二叉树
 */

public class Tree4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {

        if(pre==null){
            return null;
        }
        HashMap<Integer, Integer> hashMap=new HashMap<>();
        for (int i = 0; i <vin.length ; i++) {
            hashMap.put(vin[i],i);
        }
        return process(pre,0,pre.length-1,0,vin.length-1,hashMap);


    }

    private TreeNode process(int[] pre, int prel, int prer, int vinl, int vinr, HashMap<Integer, Integer> hashMap) {
        if(prel>prer||vinl>vinr){
            return null;
        }
        if(prel==prer||vinl==vinr){
            return new TreeNode(pre[prel]);

        }
        TreeNode a=new TreeNode(pre[prel]);
        int vinsize=hashMap.get(pre[prel]);
        int lefttree=vinsize-vinl;
        a.left=process(pre,prel+1,prel+lefttree,vinl,vinsize-1,hashMap);
        a.right=process(pre,prel+lefttree+1,prer,vinsize+1,vinr,hashMap);
        return a;
    }


}
