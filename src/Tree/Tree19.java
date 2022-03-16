package Tree;

/**
 * JZ68 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 1.对于该题的最近的公共祖先定义:对于有根树T的两个节点p、q，最近公共祖先LCA(T,p,q)表示一个节点x，满足x是p和q的祖先且x的深度尽可能大。在这里，一个节点也可以是它自己的祖先.
 * 2.二叉搜索树是若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值
 * 3.所有节点的值都是唯一的。
 * 4.p、q 为不同节点且均存在于给定的二叉搜索树中。
 */

public class Tree19 {
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        return Func(root,p,q).val;
    }

    private TreeNode Func(TreeNode root, int p, int q) {
        if(root==null||root.val==p||root.val==q||(p<root.val&&q>root.val)||(p>root.val&&q<root.val)){
            return root;
        }
        TreeNode left=Func(root.left,p,q);
        TreeNode right=Func(root.right,p,q);
        if(left==null){
            return right;
        }
        return left;

    }

}
