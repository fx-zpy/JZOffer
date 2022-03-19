package Mock;

import java.util.ArrayList;

/**
 * JZ20 表示数值的字符串
 * 请实现一个函数用来判断字符串str是否表示数值（包括科学计数法的数字，小数和整数）。
 *
 * 科学计数法的数字(按顺序）可以分成以下几个部分:
 * 1.若干空格
 * 2.一个整数或者小数
 * 3.（可选）一个 'e' 或 'E' ，后面跟着一个整数(可正可负)
 * 4.若干空格
 *
 * 小数（按顺序）可以分成以下几个部分：
 * 1.若干空格
 * 2.（可选）一个符号字符（'+' 或 '-'）
 * 3. 可能是以下描述格式之一:
 * 3.1 至少一位数字，后面跟着一个点 '.'
 * 3.2 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 3.3 一个点 '.' ，后面跟着至少一位数字
 * 4.若干空格
 *
 * 整数（按顺序）可以分成以下几个部分：
 * 1.若干空格
 * 2.（可选）一个符号字符（'+' 或 '-')
 * 3. 至少一位数字
 * 4.若干空格
 */
public class m4 {
    public boolean isNumeric (String s) {
        // write code here

        if (s == null || s.length() == 0) {
            return false;
        }
        //去掉首位空格
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            //判定为数字，则标记numFlag
            if (Character.isDigit(s.charAt(i))) {
                numFlag = true;
                //判定为.  需要没出现过.并且没出现过e// 点在e前面
            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
                //判定为e，需要没出现过e，并且出过数字了
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                //判定为+-符号，只能出现在第一位或者紧接e后面
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                //其他情况，都是非法的
            } else {
                return false;
            }
        }
        return numFlag;
    }
}
