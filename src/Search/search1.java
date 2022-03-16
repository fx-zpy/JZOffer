package Search;

/**
 * JZ53 数字在升序数组中出现的次数
 * 给定一个长度为 n 的非降序数组和一个非负数整数 k ，要求统计 k 在数组中出现的次数
 */
public class search1 {
    public int GetNumberOfK(int [] array , int k) {

        int flag=0;
        for (int i = 0; i < array.length; i++) {
            if(k==array[i]){
                flag++;
            }
        }
        return flag;
    }
}
