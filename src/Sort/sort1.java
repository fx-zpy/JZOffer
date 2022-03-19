package Sort;

import java.util.HashSet;

/**
 * JZ3 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。存在不合法的输入的话输出-1
 *
 * 自己写的题解:https://blog.nowcoder.net/n/6f737f90683b4efeb0ea1eeed4905c2e
 */
public class sort1 {
    public int duplicate (int[] numbers) {
        HashSet<Integer> hashSet=new HashSet();
        if(numbers==null||numbers.length==0||(numbers.length==1)){
            return -1;
        }
        hashSet.add(numbers[0]);
        for (int i = 1; i <numbers.length ; i++) {
            if(numbers[i]>numbers.length-1||numbers[i]<0){
                return -1;
            }
            if(hashSet.contains(numbers[i])){
                return numbers[i];
            }
            hashSet.add(numbers[i]);

        }
        return -1;
    }
}
