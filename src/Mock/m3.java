package Mock;

import java.util.ArrayList;

/**
 * JZ67 把字符串转换成整数(atoi)
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。传入的字符串可能有以下部分组成:
 * 1.若干空格
 * 2.（可选）一个符号字符（'+' 或 '-'）
 * 3. 数字，字母，符号，空格组成的字符串表达式
 * 4. 若干空格
 *
 * 转换算法如下:
 * 1.去掉无用的前导空格
 * 2.第一个非空字符为+或者-号时，作为该整数的正负号，如果没有符号，默认为正数
 * 3.判断整数的有效部分：
 * 3.1 确定符号位之后，与之后面尽可能多的连续数字组合起来成为有效整数数字，如果没有有效的整数部分，那么直接返回0
 * 3.2 将字符串前面的整数部分取出，后面可能会存在存在多余的字符(字母，符号，空格等)，这些字符可以被忽略，它们对于函数不应该造成影响
 * 3.3  整数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231的整数应该被调整为 −231 ，大于 231 − 1 的整数应该被调整为 231 − 1
 * 4.去掉无用的后导空格
 *
 *
 * 不会TT
 */
public class m3 {
    public int StrToInt (String s) {
        int len=s.length();//给定的字符串长度
        if(len==0) {
            return 0;
        }
        int sign=1;//默认为正数
        long num=0;
        int i=0;
        while(i<len&&s.charAt(i)==' ') {
            i++;//直到找到第一个非空格字符
        }

        if(i<len) {
            if(s.charAt(i)=='-') {//第一个非空格字符是负号
                sign=-1;//修改sign，表明为负数
                i++;//定位到下一个字符
            }
            else if(s.charAt(i)=='+') {
                i++;//第一个非空格字符是正号
            }
            //非正负号，则进入下面while循环的处理
        }
        while(i<len) {
            if(s.charAt(i)>='0'&&s.charAt(i)<='9') {
                num=num*10+(s.charAt(i)-'0');
                if(sign==-1&&num*(-1)<Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                    /*
                     * 注意如果上面与逻辑后写的是num>(-1)*Integer.MIN_VALUE，结果是错的，经测试(-1)*Integer.MIN_VALUE结果
                     * 仍为Integer.MIN_VALUE，原因溢出
                     */
                else if(sign==1&&num>Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                i++;
            }
            else {
                break;//不是有效数字
            }
        }
        int res=(int)num;//返回值要求是int,所以需要做一个强制类型转换
        res*=sign;//带上它的符号
        return res;
    }
}
