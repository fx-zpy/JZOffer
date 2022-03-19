package Mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * JZ61 扑克牌顺子
 * 现在有2副扑克牌，从扑克牌中随机五张扑克牌，我们需要来判断一下是不是顺子。
 * 有如下规则：
 * 1. A为1，J为11，Q为12，K为13，A不能视为14
 * 2. 大、小王为 0，0可以看作任意牌
 * 3. 如果给出的五张牌能组成顺子（即这五张牌是连续的）就输出true，否则就输出false。
 * 4.数据保证每组5个数字，每组最多含有4个零，数组的数取值为 [0, 13]
 */
public class m2 {
    public boolean IsContinuous(int [] numbers) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE, min =Integer.MAX_VALUE;
        //遍历数组
        for (int number:
                numbers) {
            if(number == 0) {
                continue;
            }
            //包含相同牌则直接返回，否则加入
            if(set.contains(number)){
                return false;
            }else {
                set.add(number);
            }
            //每次遍历记录最大值，最小值
            max = StrictMath.max(max,number);
            min = StrictMath.min(min,number);
        }
        return max - min < 5;

    }
}
