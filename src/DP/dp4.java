package DP;

/**
 * JZ10 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个正整数 n ，请你输出斐波那契数列的第 n 项。
 *
 */
public class dp4 {
    public int Fibonacci(int n) {
        /**
         * 和dp3爬楼梯基本一致，只要将k[2]改成1即可；
         */
        int[] k=new int[42];
        k[1]=1;k[2]=1;
        for (int i = 3; i <42 ; i++) {
            k[i]=k[i-1]+k[i-2];
        }
        return k[n];
    }
}
