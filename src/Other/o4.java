package Other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * JZ21 调整数组顺序使奇数位于偶数前面(一)
 * 输入一个长度为 n 整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class o4 {
    public int[] reOrderArray (int[] array) {
        int[] ret=new int[array.length];
        Queue a=new LinkedList();
        Queue b=new LinkedList();
        if(array==null||array.length==0){
            return ret;
        }
        for (int i = 0; i <array.length ; i++) {
            if(array[i]%2==0){
                b.offer(array[i]);
            }else{
                a.offer(array[i]);
            }
        }
        int al=a.size();
        int bl=b.size();
        for (int i = 0; i <al ; i++) {
            ret[i] = (int) a.poll();
        }
        for (int i = al; i <al+bl ; i++) {
            ret[i]= (int) b.poll();
        }
        return ret;

    }

    /**
     * 别人的奇妙解法
     * @param array
     * @return
     */
    //使用插入排序的思想
    public int[] reOrderArray1(int[] array) {
        // 首先是对数值长度进行特判
        if(array==null||array.length==0){
            return array;
        }
        //记录已经是奇数的位置
        int j=0;
        int temp = 0;
        for(int i =0;i<array.length;i++){
            temp = array[i];
            //如果该值为偶数
            if(array[i]%2==0){
                continue;
            }else{//该值为奇数
                int k =i;
                while(k>j){
                    //这区间整体向后移动一位
                    array[k] = array[k-1];
                    k--;
                }
                //移位之后将对应的值赋值
                array[k] = temp;
                j++;
            }
        }
        //返回结果数数组
        return array;
    }
}
