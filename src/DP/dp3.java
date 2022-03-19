package DP;

/**
 * JZ69 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class dp3 {
    public int jumpFloor(int target) {

        int[] k=new int[42];
        k[1]=1;k[2]=2;
        for (int i = 3; i <42 ; i++) {
            k[i]=k[i-1]+k[i-2];
        }
        return k[target];

    }
}
