package Other;

/**
 * JZ17 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 1. 用返回一个整数列表来代替打印
 * 2. n 为正整数，0 < n <= 5
 */
public class o17 {
    public int[] printNumbers (int n) {
        // write code here
        int[] ret=new int[(int) (Math.pow(10,n)-1)];
        int k=1;
        for (int i = 0; i <ret.length ; i++) {
            ret[i]=k++;
        }
        return ret;

    }
}
