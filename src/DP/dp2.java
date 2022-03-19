package DP;

import java.util.Arrays;

/**
 * JZ42 连续子数组的最大和(二)
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，找到一个具有最大和的连续子数组。
 * 1.子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 * 2.如果存在多个最大和的连续子数组，那么返回其中长度最长的，该题数据保证这个最长的只存在一个
 * 3.该题定义的子数组的最小长度为1，不存在为空的子数组，即不存在[]是某个数组的子数组
 * 4.返回的数组不计入空间复杂度计算
 */
public class dp2 {
    public int[] FindGreatestSumOfSubArray (int[] array) {
        //动态规划
        int sum = array[0],num = array[0];
        //当前遍历位置子串首尾位置
        int start_tmp = 0, end_tmp = 1;
        //最大和子串首尾位置
        int start = 0, end = 1;
        for(int i = 1; i < array.length; i++){
            //数组中包含i位置的连续串最大值（比较当前数组值与之前累加值大小）
            if(array[i] > num + array[i]){
                num = array[i];
                start_tmp = i;
                end_tmp = i + 1;
            }else{
                num = num + array[i];
                end_tmp++;
            }
            //记录并更新当前遍历数组的最大子串和
            if(num > sum || (num == sum) && (end_tmp - start_tmp) > (end - start)){
                sum = num;
                start = start_tmp;
                end = end_tmp;
            }
        }
        return Arrays.copyOfRange(array,start,end);
    }
}
