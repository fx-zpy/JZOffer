package Tree;

import java.util.ArrayList;

/**
 * JZ8 二叉树的下一个结点
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。
 */

public class Tree13 {

    static ArrayList<TreeLinkNode> list = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        TreeLinkNode par = pNode;
        while(par.next != null){
            par = par.next;
        }
        InOrder(par);
        for(int i=0;i<list.size();i++){
            if(pNode == list.get(i)){
                return i == list.size()-1?null:list.get(i+1);
            }
        }
        return null;
    }
    void InOrder(TreeLinkNode pNode){
        if(pNode!=null){
            InOrder(pNode.left);
            list.add(pNode);
            InOrder(pNode.right);
        }
    }
}
