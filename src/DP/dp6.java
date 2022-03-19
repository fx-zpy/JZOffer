package DP;

/**
 * JZ71 跳台阶扩展问题
 */
public class dp6 {
    /**
     * 初始解法
     */
//    public int jumpFloorII(int target) {
//
//        int[] k = new int[42];
//        k[1] = 1;
//        k[2] = 2;
//        for (int i = 3; i < 42; i++) {
//            k[i] = dp(i, k);
//        }
//        return k[target];
//    }
//
//    private int dp(int i, int[] k) {
//        int ret = 0;
//        for (int j = 1; j < i; j++) {
//            ret += k[j];
//        }
//        return ret + 1;
//    }
    /**
     * 优化
     */
    public int jumpFloorII(int target) {

        int[] k=new int[42];
        for (int i = 1; i <42 ; i++) {
            k[i]= (int) Math.pow(2,i-1);
        }
        return k[target];
    }
}
