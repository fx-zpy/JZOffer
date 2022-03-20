package Other;

/**
 * JZ83 剪绳子（进阶版）
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长的 m 段（ m 、 n 都是整数， n > 1 并且 m > 1 ， m <= n ）
 * 每段绳子的长度记为 k[1],...,k[m] 。请问 k[1]*k[2]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到的最大乘积是 18 。
 *
 * 由于答案过大，请对 998244353 取模。
 */
public class o16 {
    public long pow (long cnt) {
        // 如何快速计算3的cnt次幂?
        if (cnt == 0) {
            return 1;
        }
        if (cnt == 1) {
            return 3;
        }
        long part = pow(cnt / 2);
        if (cnt % 2 == 0) {
            return part * part % 998244353;
        }
        return 3 * part * part % 998244353;
    }
    public long cutRope (long number) {
        // write code here
        if (number == 2) {
            return 1;
        }
        if (number == 3) {
            return 2;
        }
        long cnt = number / 3;
        if (number % 3 == 0) {
            return pow(cnt) % 998244353;
        } else if (number % 3 == 1) {
            cnt--;
            return 2 * 2 * pow(cnt) % 998244353;
        } else {
            return 2 * pow(cnt) % 998244353;
        }
    }
}
