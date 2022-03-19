package Other;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * JZ45 把数组排成最小的数
 * 输入一个非负整数数组numbers，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组[3，32，321]，则打印出这三个数字能排成的最小数字为321323。
 * 1.输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 2.拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */
public class o7 {
    public String PrintMinNumber(int [] numbers) {
        /**
         * 大佬的一行代码，我看懂都比较费事，tql
         */
        return Arrays.stream(numbers).boxed().map(String::valueOf).sorted((a, b) -> (a + b).compareTo(b + a)).collect(Collectors.joining(""));
    }
}
