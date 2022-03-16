package Search;

/**
 *JZ4 二维数组中的查找
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class search2 {
    public boolean Find(int target, int [][] array) {

        /**
         * 暴力
         */

//        for (int i = 0; i <array.length ; i++) {
//            for (int j = 0; j <array[0].length ; j++) {
//                if(array[i][j]==target){
//                    return true;
//                }
//            }
//
//        }
//        return false;
        /**
         * 根据二维数组的特性从左下角开始寻找，
         */
        int rows = array.length;
        if(rows == 0){
            return false;
        }
        int cols = array[0].length;
        if(cols == 0){
            return false;
        }
        // 左下
        int row = rows-1;
        int col = 0;
        while(row>=0 && col<cols){
            if(array[row][col] < target){
                col++;
            }else if(array[row][col] > target){
                row--;
            }else{
                return true;
            }
        }
        return false;
    }
}
