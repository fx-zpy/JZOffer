package Tree;

import java.util.*;

/**
 * JZ86 在二叉树中找到两个节点的最近公共祖先
 * 给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 * 注：本题保证二叉树中每个节点的val值均不相同。
 */

public class Tree18 {
    /**
     * 递归写法
     */
//    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
//        return Func(root,o1,o2).val;
//    }
//
//    private TreeNode Func(TreeNode root, int o1, int o2) {
//        if(root==null||root.val==o1||root.val==o2){
//            return root;
//        }
//        TreeNode left=Func(root.left,o1,o2);
//        TreeNode right=Func(root.right,o1,o2);
//        //如果left为空，说明这两个节点在root结点的右子树上
//        if(left==null){
//            return right;
//        }
//        if(right==null){
//            return left;
//        }
//        return root;
//    }
    /**
     * 非递归写法
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        //记录每个结点的父节点
        Map<Integer,Integer> map=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        //根结点没有父节点，赋值为默认值
        map.put(root.val,Integer.MIN_VALUE);
        queue.add(root);
        while(!map.containsKey(o1)||!map.containsKey(o2)){
            TreeNode a=queue.poll();
            if(a.left!=null){
                map.put(a.left.val,a.val);
                queue.add(a.left);
            }
            if(a.right!=null){
                map.put(a.right.val,a.val);
                queue.add(a.right);
            }

        }
        Set<Integer> set=new HashSet<>();
        while(map.containsKey(o1)){
            set.add(o1);
            o1=map.get(o1);
        }
        while(!set.contains(o2)){
            o2=map.get(o2);
        }
        return o2;

    }



}
