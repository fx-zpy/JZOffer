package Other;

/**
 * JZ81 调整数组顺序使奇数位于偶数前面(二)
 * 输入一个长度为 n 整数数组，数组里面可能含有相同的元素，
 * 实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，
 * 对奇数和奇数，偶数和偶数之间的相对位置不做要求，
 * 但是时间复杂度和空间复杂度必须如下要求。
 * 要求：时间复杂度 O(n)，空间复杂度 O(1)
 */
public class o15 {
    public int[] reOrderArrayTwo (int[] array) {
//        // write code here
//        // 首先是对数值长度进行特判
//        if(array==null||array.length==0){
//            return array;
//        }
//        //记录已经是奇数的位置
//        int j=0;
//        int temp = 0;
//        for(int i =0;i<array.length;i++){
//            temp = array[i];
//            //如果该值为偶数
//            if(array[i]%2==0){
//                continue;
//            }else{//该值为奇数
//                int k =i;
//                while(k>j){
//                    //这区间整体向后移动一位
//                    array[k] = array[k-1];
//                    k--;
//                }
//                //移位之后将对应的值赋值
//                array[k] = temp;
//                j++;
//            }
//        }
//        //返回结果数数组
//        return array;
        /**
         * 双指针，从数组两头向中间靠近。
         * 左边的为奇数指针，右边的为偶数指针。
         * 左边指针在没有遇到偶数时，就向右移动，遇到偶数立即停止；
         * 右边指针再没有遇到奇数时，向左边移动，遇到奇数时，进行奇偶指针元素交换。
         * 交换之后切换到奇数指针工作。这个方法只遍历一遍数组，时间o(n),空间o(1)。
         */
        int low = 0;
        int high = array.length-1;
        while(low<high){
            while(low<high&&array[low]%2==1){
                ++low;
            }
            while(low<high&&array[high]%2==0){
                --high;
            }
            if(low<high){
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }
        return array;
    }
}
