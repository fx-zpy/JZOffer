package Byte;

import java.util.ArrayList;

/**
 * JZ65 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 这是什么智障题目。。。。。
 */
public class b1 {
    public int Add(int a,int b) {
        if (a == 0 || b == 0){
            return a ^ b;
        }
        return Add(a ^ b, (a & b) << 1);
    }
}
