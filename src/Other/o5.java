package Other;

import java.util.Arrays;

/**
 * JZ39 数组中出现次数超过一半的数字
 * 给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 */
public class o5 {
    public int MoreThanHalfNum_Solution(int [] array) {

        if(array.length==1||array.length==2){
            return array[0];
        }
        Arrays.sort(array);

        if(array.length%2==0){
            for (int i = 0; i <array.length/2 ; i++) {
                if(array[i]==array[i+array.length/2]){
                    return array[i];
                }
            }
        }else{
            for (int i = 0; i <array.length/2+1 ; i++) {
                if(array[i]==array[i+array.length/2]){
                    return array[i];
                }
            }
        }
        return -1;

    }
}
