package Search;

import java.util.ArrayList;

/**
 * JZ38 字符串的排列
 * 输入一个长度为 n 字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
 * 例如输入字符串ABC,则输出由字符A,B,C所能排列出来的所有字符串ABC,ACB,BAC,BCA,CBA和CAB
 */
public class search4 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arr=new ArrayList<>();
        if(str.length()==0){
            return arr;
        }
        Func(str,"",arr);
        return arr;

    }

    private void Func(String str, String s, ArrayList<String> arr) {
        if(str.length()==0){
            if(!arr.contains(s)){
                arr.add(s);
            }
        }
        for (int i = 0; i <str.length() ; i++) {
            Func(str.substring(0,i)+str.substring(i+1,str.length()),s+str.charAt(i),arr);
        }
    }
}
