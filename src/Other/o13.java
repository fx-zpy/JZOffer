package Other;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g" 。
 * 当从该字符流中读出前六个字符 “google" 时，第一个只出现一次的字符是"l"。
 *
 * 数据范围：字符串长度满足1≤n≤1000  ，字符串中出现的字符一定在 ASCII 码内。
 *
 * 后台会用以下方式调用 Insert 和 FirstAppearingOnce 函数
 * string caseout = "";
 * 1.读入测试用例字符串casein
 * 2.如果对应语言有Init()函数的话，执行Init() 函数
 * 3.循环遍历字符串里的每一个字符ch {
 * Insert(ch);
 * caseout += FirstAppearingOnce()
 * }
 * 2. 输出caseout，进行比较。
 */
public class o13 {
    String input = "";
    Map<Character,Integer> map = new HashMap<>();

    public void Insert(char ch)
    {
        if(!map.keySet().contains(ch)){
            map.put(ch,1);
        }else{
            map.put(ch,map.get(ch)+1);
        }
        input += ch;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int index = Integer.MAX_VALUE;
        char result = '#';
        for(Character c: map.keySet()){
            if(map.get(c) == 1){
                if(input.indexOf(c) < index){
                    index = input.indexOf(c);
                    result = input.charAt(index);
                }
            }
        }
        return result;
    }
}
