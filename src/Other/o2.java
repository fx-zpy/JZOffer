package Other;

import java.util.HashSet;

/**
 * JZ50 第一个只出现一次的字符
 * 在一个长为 字符串中找到第一个只出现一次的字符,并返回它的位置
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class o2 {
    public int FirstNotRepeatingChar(String str) {

        if(str==null||str.length()==0){
            return -1;
        }
        if(str.length()==1){
            return 0;
        }
        HashSet<Character> a=new HashSet();
        HashSet<Character> b=new HashSet();
        a.add(str.charAt(0));
        for (int i = 1; i <str.length() ; i++) {
            if(a.contains(str.charAt(i))){
                b.add(str.charAt(i));
            }
            a.add(str.charAt(i));
        }
        for (int i = 0; i <str.length() ; i++) {
            if(!b.contains(str.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
