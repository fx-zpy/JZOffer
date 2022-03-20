package Other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * JZ57 和为S的两个数字
 * 输入一个递增排序的数组array和一个数字S，在数组中查找两个数，使得他们的和正好是S
 * 如果有多对数字的和等于S，返回任意一组即可，如果无法找出这样的数字，返回一个空数组即可。
 */
public class o10 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        /**
         * 思路：暴力，但是时间复杂度为O(n^2)
         */
//        ArrayList<Integer> arr = new ArrayList<>();
//        if(array==null||array.length==0||array.length==1||(array.length==2&&(array[0]+array[1]!=sum))){
//            return arr;
//        }
//        for (int i = 0; i <array.length-1&&array[i]<sum ; i++) {
//            for (int j = i+1; j <array.length&&array[i]<sum ; j++) {
//                if(array[i]+array[j]==sum){
//                    arr.add(array[i]);
//                    arr.add(array[j]);
//                    return arr;
//                }
//            }
//        }
//        return arr;
        /**
         * 优化，使用升序的特点
         *
         */
        ArrayList<Integer> arr = new ArrayList<>();
        int len=array.length;
        int l=0, r=len-1;
        while(r>0 && array[r]>=sum){
            r--;
        }
        while(l<r){
            if(array[l]+array[r]<sum){
                l++;
            }
            else if(array[l]+array[r]>sum){
                r--;
            }
            else{
                arr.add(array[l]);
                arr.add(array[r]);
                return arr;
            }
        }
        return arr;

    }
}
