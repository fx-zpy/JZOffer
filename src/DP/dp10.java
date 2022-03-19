package DP;

import java.util.HashMap;

/**
 * JZ48 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class dp10 {
    public int lengthOfLongestSubstring (String s) {
        // write code here
        if(s==null) {
            return 0;
        }
        char[]array=s.toCharArray();
        if(array.length==1){
            return 1;
        }
        int[]dp=new int[array.length];
        int maxLength=1;
        HashMap<Character, Integer> map=new HashMap<>();
        dp[0]=1;
        map.put(array[0],0);
        for(int i=1;i<array.length;i++){
            dp[i]=1;
            if(!map.containsKey(array[i])){
                dp[i]=dp[i-1]+1;
            }
            else{
                dp[i]=Math.min(dp[i-1]+1,i-map.get(array[i]));
            }
            map.put(array[i],i);
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}
