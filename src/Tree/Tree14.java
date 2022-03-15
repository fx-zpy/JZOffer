package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * JZ28 对称的二叉树
 * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 */

public class Tree14 {

//    static ArrayList<Integer> arr = new ArrayList<>();
//    boolean isSymmetrical(TreeNode pRoot) {
//        /**
//         * 想法：是否为镜像就是看中序遍历是否是对称的
//         *处理方法有问题，如果为空我直接跳过，这样的话会有如下特殊二叉树无法识别为错误
//         *               1
//         *           2       3
//         *        3        2
//         * 这个二叉树的中序遍历是32123，对称，但是不是镜像，这里需要将为空的情况下赋一个不可能的值，题目的数据范围是节点数满足10000≤n≤1000，节点上的值满足 ∣val∣≤1000
//         *
//         */
//        if(pRoot==null){
//            return true;
//        }
//        InOrder(pRoot);
//        if(arr.size()%2==0){
//            return false;
//        }
//        for (int i = 0; i <(arr.size()-1)/2 ; i++) {
//            if(!arr.get(i).equals(arr.get(arr.size()-1-i))){
//                return false;
//            }
//        }
//        return true;
//
//
//    }
//
//    private void InOrder(TreeNode pRoot) {
//        if(pRoot==null){
//            arr.add(1005);
//        }
//        if(pRoot!=null){
//            InOrder(pRoot.left);
//            arr.add(pRoot.val);
//            InOrder(pRoot.right);
//        }
//    }
    int INF = 0x3f3f3f3f;
    TreeNode emptyNode = new TreeNode(INF);
    boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> d = new ArrayDeque<>();
        d.add(root);
        while (!d.isEmpty()) {
            // 每次循环都将下一层拓展完并存到「队列」中
            // 同时将该层节点值依次存入到「临时列表」中
            int size  = d.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode poll = d.pollFirst();
                if (!poll.equals(emptyNode)) {
                    d.addLast(poll.left != null ? poll.left : emptyNode);
                    d.addLast(poll.right != null ? poll.right : emptyNode);
                }
                list.add(poll.val);
            }

            // 每一层拓展完后，检查一下存放当前层的该层是否符合「对称」要求
            if (!check(list)) {
                return false;
            }
        }
        return true;
    }

    // 使用「双指针」检查某层是否符合「对称」要求
    boolean check(List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
