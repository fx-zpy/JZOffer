package DP;

/**
 * JZ42 连续子数组的最大和
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。求所有子数组的和的最大值。
 */
public class dp1 {
    public int FindGreatestSumOfSubArray(int[] array) {

        int sum=0;
        int max=array[0];
        for (int i = 0; i <array.length ; i++) {
            sum=Math.max(sum+array[i],array[i]);
            max=Math.max(sum,max);
        }
        return max;
    }
}
