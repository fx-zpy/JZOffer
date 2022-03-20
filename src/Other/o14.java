package Other;

/**
 * JZ14 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长的 m 段
 * （ m 、 n 都是整数， n > 1 并且 m > 1 ， m <= n ）
 * 每段绳子的长度记为 k[1],...,k[m] 。
 * 请问 k[1]*k[2]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到的最大乘积是 18 。
 */
public class o14 {
    public int cutRope(int target) {
        /**
         * 这道题和之前lc上面的遇到题目几乎一样，用数学公式求导可得剪成3段比两段更优
         */
        if (target == 2 || target == 3) {
            return target - 1;
        }
        int res = 1;
        while (target > 4) {
            //如果target大于4，我们不停的让他减去3
            target = target - 3;
            //计算每段的乘积
            res = res * 3;
        }
        return target * res;
    }
}
