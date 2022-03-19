package Other;

/**
 * JZ66 构建乘积数组
 * 给定一个数组 A[0,1,...,n-1] ,请构建一个数组 B[0,1,...,n-1]
 * 其中 B 的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]（除 A[i] 以外的全部元素的的乘积）。
 * 程序中不能使用除法。（注意：规定 B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2]）
 * 对于 A 长度为 1 的情况，B 无意义，故而无法构建，用例中不包括这种情况。
 */
public class o1 {
    public int[] multiply(int[] A) {

        int[] B=new int[A.length];
        for (int i = 0; i <B.length ; i++) {
            B[i]=1;
        }
        for (int i = 0; i <A.length ; i++) {
            for (int j = 0; j <A.length; j++) {
                if(j==i){
                    continue;
                }
                B[i]*=A[j];
            }
        }
        return B;
    }
}
