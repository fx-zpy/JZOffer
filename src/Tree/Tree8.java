package Tree;

import java.util.Arrays;

/**
 * JZ33 二叉搜索树的后序遍历序列
 */

public class Tree8 {
    public boolean VerifySquenceOfBST(int [] sequence) {

        if(sequence.length==0){
            return false;
        }
        return Judge(sequence);
    }

    private boolean Judge(int[] sequence) {
        if(sequence.length<1){
            return true;
        }
        int flag=0;
        int root=sequence[sequence.length-1];
        //找左右子树的分界值
        while(flag<sequence.length-1){
            if(sequence[flag]>root){
                break;
            }
            flag++;
        }
        //校验右子树中是否全部元素大于根。
        int temp=flag;
        while(temp<sequence.length-1){
            if(sequence[temp]<root){
                return false;
            }
            temp++;
        }
        boolean left=Judge(Arrays.copyOfRange(sequence,0,flag));
        boolean right=Judge(Arrays.copyOfRange(sequence,flag,sequence.length-1));
        return left&&right;
    }

}
