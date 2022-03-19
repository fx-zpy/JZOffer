package DP;

/**
 * JZ46 把数字翻译成字符串
 * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
 *
 * 现在给一串数字，返回有多少种可能的译码结果
 */
public class dp11 {
    public int solve (String nums) {
        if(nums==null ||nums.length()==0) {
            return 0;
        }
        int[] dp = new int[nums.length()+1];
        dp[0]=1;
        dp[1]=nums.charAt(0)=='0'?0:1;
        for(int i=2;i<dp.length;i++){
            //无法独立编码也无法组合编码
            if(nums.charAt(i-1)=='0' && (nums.charAt(i-2)=='0' || nums.charAt(i-2)>'2')){
                return 0;
                //只能组合编码
            }else if(nums.charAt(i-1)=='0'){
                dp[i] = dp[i-2];
                //只能独立编码
            }else if(nums.charAt(i-2)=='0' || nums.charAt(i-2)>'2' || nums.charAt(i-2)=='2'&& nums.charAt(i-1)>'6' ){
                dp[i] = dp[i-1];
                //两种编码方式都可以
            }else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[nums.length()];
    }
}
