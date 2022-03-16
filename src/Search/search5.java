package Search;

/**
 * JZ44 数字序列中某一位的数字
 * 数字以 0123456789101112131415... 的格式作为一个字符序列，
 * 在这个序列中第 2 位（从下标 0 开始计算）是 2 ，第 10 位是 1 ，第 13 位是 1 ，
 * 以此类题，请你输出第 n 位对应的数字。
 */
public class search5 {
    public int findNthDigit (int n) {
        // write code here
        // 0
        // 1 ~ 9      | digit = 1 start = 1 * 1       count = 1 * 9 * 1
        // 10 ~ 99    | digit = 2 start = 1 * 10      count = 10 * 9 * 2
        // 100 ~ 999  | digit = 3 start = 1 * 10 * 10 count = 100 * 9 * 3
        if (n <= 0) {
            return 0;
        }
        long start = 1, digit = 1, count = 9;
        while (n > count) {
            n -= count; // 减去当前位数的总长度
            start *= 10;
            digit += 1;
            count = start * 9 * digit;
        }
        // 找到当前位数的区间了
        String num = (start + (n - 1) / digit) + ""; // 减去第0号元素0
        int idx = (int)((n - 1) % digit);
        return Integer.parseInt(num.charAt(idx) + "");
    }
}
