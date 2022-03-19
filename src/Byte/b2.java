package Byte;

/**
 * JZ15 二进制中1的个数
 * 输入一个整数 n ，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */
public class b2 {
    public int NumberOf1(int n) {
        n = (n & 0x55555555) + ((n >>> 1)  & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2)  & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4)  & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8)  & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }
}
