package Tree;

/**
 * JZ84 二叉树中和为某一值的路径(三)
 * 给定一个二叉树root和一个整数值 sum ，求该树有多少路径的的节点值之和等于 sum 。
 * 1.该题路径定义不需要从根节点开始，也不需要在叶子节点结束，但是一定是从父亲节点往下到孩子节点
 * 2.总节点数目为n
 * 3.保证最后返回的路径个数在整形范围内(即路径个数小于2^31-1)
 *
 * 数据范围:
 * 0<=n<=10000
 * -10^9<=节点值<=10^9
 *
 */

public class Tree17 {
    static int ret=0;
    public int FindPath (TreeNode root, int sum) {

        if(root==null){
            return ret;
        }
        DFS(root,sum);
        FindPath(root.left,sum);
        FindPath(root.right,sum);
        return ret;

    }

    private void DFS(TreeNode root, int sum) {
        if(root==null){
            return;
        }
        if(sum==root.val){
            ret++;
        }
        DFS(root.left,sum-root.val);
        DFS(root.right,sum-root.val);
    }
}
