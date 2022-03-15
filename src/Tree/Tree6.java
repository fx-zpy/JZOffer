package Tree;

/**
 * JZ27 二叉树的镜像
 */

public class Tree6 {
    public TreeNode Mirror (TreeNode pRoot) {

        if(pRoot==null){
            return null;
        }
        if(pRoot!=null){
            TreeNode temp=pRoot.left;
            pRoot.left=pRoot.right;
            pRoot.right=temp;
            pRoot.left=Mirror(pRoot.left);
            pRoot.right=Mirror(pRoot.right);
        }
        return pRoot;


    }

}
