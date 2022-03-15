package Tree;

import java.util.*;

/**
 * JZ82 二叉树中和为某一值的路径(二)
 * 输入一颗二叉树的根节点root和一个整数expectNumber，找出二叉树中结点值的和为expectNumber的所有路径。
 * 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
 * 2.叶子节点是指没有子节点的节点
 * 3.路径只能从父节点到子节点，不能从子节点到父节点
 * 4.总节点数目为n
 */

public class Tree10 {
//     HashMap<ArrayList<Integer>,Integer> hashMap=new HashMap<>();
//     ArrayList<ArrayList<Integer>> ret=new ArrayList<>();
//     ArrayList<Integer> temp=new ArrayList<>();
//     int sum=0;
//    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
//        if(root==null){
//            return ret;
//        }
//        temp.add(root.val);
//        sum+=root.val;
//        if(root.left==null&&root.right==null){
//            hashMap.put(temp,sum);
//            temp=new ArrayList<>();
//            sum=0;
//        }
//        FindPath(root.left,expectNumber);
//        FindPath(root.right,expectNumber);
//
//
//        ret=getKey(hashMap,expectNumber);
//        return ret;
//
//
//    }
//
//    /**
//     * 根据value来获取对应HashMap的Key
//     * @param map
//     * @param value
//     * @return
//     */
//    public ArrayList<ArrayList<Integer>> getKey(HashMap<ArrayList<Integer>,Integer> map, int value){
//        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
//        Iterator it=map.entrySet().iterator();
//        while(it.hasNext()){
//            Map.Entry entry= (Map.Entry) it.next();
//            Object key = entry.getKey();
//            Object val = entry.getValue();
//            if(val.equals(value)){
//                ret.add((ArrayList<Integer>) key);
//            }
//        }
//        return ret;
//    }
    /**
     * 其他人的解法
     */
    private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    private Stack<Integer> path = new Stack<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root ==null) return paths;
        path.push(root.val);
        target -= root.val;

        if(target == 0 && root.left == null && root.right ==null){
            paths.add(new ArrayList<Integer>(path));
        }

        FindPath(root.left,target);
        FindPath(root.right,target);
        path.pop();

        return paths;
    }


}
