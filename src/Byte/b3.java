package Byte;

/**
 * JZ16 数值的整数次方
 * 实现函数 double Power(double base, int exponent)，求base的exponent次方。
 */
public class b3 {
    public double Power(double base, int exponent) {

        if(exponent>=0){
            if(exponent==0){
                return (double) 1;
            }if(exponent==1){
                return (double) base;
            }
            double temp=base;
            for (int i = 1; i <exponent ; i++) {
                base*=temp;
            }
        }else{
            if(exponent==-1){
                return (double) 1/base;
            }
            double temp=base;
            for (int i = 1; i <-exponent ; i++) {
                base*=temp;
            }
            base=1/base;
        }

        return base;
    }
}
