package Tree;

/**
 * JZ36 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
 * 注意:
 * 1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
 * 2.返回链表中的第一个节点的指针
 * 3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
 * 4.你不用输出双向链表，程序会根据你的返回值自动打印输出
 */

public class Tree11 {
    TreeNode pre= null;
    TreeNode root=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree ==null) {
            return null;
        }
        Convert(pRootOfTree.left);
        if(root == null){
            root=pRootOfTree;
        }
        if(pre!=null){
            pRootOfTree.left=pre;
            pre.right=pRootOfTree;
        }
        pre=pRootOfTree;
        Convert(pRootOfTree.right);
        return root;
    }

}
