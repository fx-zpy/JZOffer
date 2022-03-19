package DP;

/**
 * JZ63 买卖股票的最好时机(一)
 * 假设你有一个数组prices，长度为n，其中prices[i]是股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
 * 1.你可以买入一次股票和卖出一次股票，并非每天都可以买入或卖出一次，总共只能买入和卖出一次，且买入必须在卖出的前面的某一天
 * 2.如果不能获取到任何利润，请返回0
 * 3.假设买入卖出均无手续费
 */
public class dp8 {
    public int maxProfit (int[] prices) {
//        int max=0;
//        for (int i = 0; i <prices.length-1 ; i++) {
//            for (int j = i+1; j <prices.length ; j++) {
//                if(prices[j]>prices[i]){
//                    max=max>(prices[j]-prices[i])?max:(prices[j]-prices[i]);
//                }
//            }
//        }
//        return max;
        int len = prices.length;
        int minPrices = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<len;i++){
            //寻找最低点
            if(prices[i]<minPrices){
                minPrices = prices[i];
            }else if(prices[i]-minPrices>ans){
                //更新答案（最大利润）
                ans = prices[i]-minPrices;
            }
        }
        return ans;
    }
}
