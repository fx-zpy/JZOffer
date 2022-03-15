package Tree;

import java.util.Stack;

/**
 * JZ54 二叉搜索树的第k个节点
 */

public class Tree3 {
    public int KthNode (TreeNode proot, int k) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode a=proot;
        if(proot==null){
            return -1;
        }
        stack.push(proot);
        int flag=0;
        while(!stack.isEmpty()){
            while(a.left!=null){
                stack.push(a.left);
                a=a.left;
            }
            flag++;
            if(flag==k){
                return stack.pop().val;

            }
            TreeNode temp=stack.pop();
            if(temp.right!=null){
                stack.push(temp.right);
                a=temp.right;
            }
        }
        return -1;
    }
}
