package Other;

/**
 * JZ5 替换空格
 * 请实现一个函数，将一个字符串s中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class o3 {
    public String replaceSpace (String s) {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)==' '){
                stringBuilder.append("%20");
            }else{
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
