package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * JZ37 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树，不对序列化之后的字符串进行约束，但要求能够根据序列化之后的字符串重新构造出一棵与原二叉树相同的树。
 *
 * 二叉树的序列化(Serialize)是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树等遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#）
 *
 * 二叉树的反序列化(Deserialize)是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */

public class Tree16 {
    int INF=0x3f3f3f3f;
    TreeNode emptyNode=new TreeNode(INF);
    String Serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            TreeNode poll=deque.pollFirst();
            sb.append(poll.val+"_");
            if(!poll.equals(emptyNode)){
                deque.addLast(poll.left!=null?poll.left:emptyNode);
                deque.addLast(poll.right!=null?poll.right:emptyNode);
            }
        }
        return sb.toString();

    }
    TreeNode Deserialize(String str) {
        if(str.equals("")){
            return null;
        }
        String[] s=str.split("_");
        int l=s.length;
        TreeNode root=new TreeNode(Integer.parseInt(s[0]));
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.addLast(root);
        for (int i = 1; i <l-1 ; i+=2) {
            TreeNode poll=deque.pollFirst();
            int a=Integer.parseInt(s[i]);
            int b=Integer.parseInt(s[i+1]);
            if(a!=INF){
                poll.left=new TreeNode(a);
                deque.addLast(poll.left);
            }
            if(b!=INF){
                poll.right=new TreeNode(b);
                deque.addLast(poll.right);
            }
        }
        return root;

    }

}
