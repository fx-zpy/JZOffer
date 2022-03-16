package Search;

/**
 * JZ11 旋转数组的最小数字
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，
 * 即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，
 * 比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。
 * 请问，给定这样一个旋转数组，求数组中的最小值。
 */
public class search3 {
    public int minNumberInRotateArray(int [] array) {

        for (int i = 0; i <array.length-1 ; i++) {
            if(array[i]>array[i+1]){
                return array[i+1];
            }
        }
        return array[0];
    }
}
