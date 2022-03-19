package Byte;


import java.util.Arrays;
import java.util.HashSet;

/**
 * JZ56 数组中只出现一次的两个数字
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class b4 {
    public int[] FindNumsAppearOnce (int[] array) {
        int[] ret=new int[2];
        HashSet<Integer> hashSet = new HashSet();
        HashSet<Integer> hashSet1 = new HashSet();
        hashSet.add(array[0]);
        for (int i = 1; i <array.length ; i++) {
            if(hashSet.contains(array[i])){
                hashSet1.add(array[i]);
                hashSet.add(array[i]);
            }
            hashSet.add(array[i]);
        }
        int k=0;
        for (int i = 0; i <array.length ; i++) {
            if(!hashSet1.contains(array[i])){
                ret[k++]=array[i];
            }
        }
        Arrays.sort(ret);
        return ret;
    }
}
