package Other;

import java.util.ArrayList;

/**
 * JZ74 和为S的连续正数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 */
public class o9 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer> > ans = new ArrayList();
        // (2s+n-1)*n = 2sum >= n^2+n >n^2
        // 所以，n < sqrt(2sum)
        int maxBound = (int)Math.ceil(Math.sqrt(2 * sum));
        // 至少包含两个数，因此n（即i）至少为2
        // n从后向前遍历符合首项从小到大的要求（n越大，首项越小）
        for (int i = maxBound - 1; i >= 2 ; i--) {
            // 查看是否能够整除
            if (2*sum%i!=0) {
                continue;
            }
            if ((2*sum/i+1-i)%2!=0) {
                continue;
            }
            // 找到了满足的列表
            int start = (2*sum/i+1-i)/2;
            ArrayList list = new ArrayList();
            for (int j = 0; j < i; j++) {
                list.add(start+j);
            }
            ans.add(list);
        }
        return ans;
    }
}
