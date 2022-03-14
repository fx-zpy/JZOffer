package QueueAndStack;


import java.util.ArrayList;

/**
 * JZ59 滑动窗口的最大值
 */
public class QAS5 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> myres=new ArrayList<>();
        if(num==null||size==0||num.length<size){return myres;}
        //判断条件，当num的大小等于0或者滑动窗口的size小于1或者滑动窗口移动到数组最后面时
        //以上这些情况都会直接返回结果
        int tmp=0;
        int maxNum=num[0];
        for(int i=1;i<size;i++){//在滑动窗口中进行判断
            if(num[i]>maxNum){
                tmp=i;
                maxNum=num[i];
            }
        }
        myres.add(maxNum);
        int j=size;
        while(j<num.length){
            if(num[j]>=maxNum){//优化判断，当滑动窗口移动到下一个位置时进行相应判断
                maxNum=num[j];
                tmp=j;
            }else{
                if(j-size+1>tmp){
                    maxNum=num[j-size+1];
                    tmp=j-size+1;
                    for(int i=j-size+1;i<=j;i++){
                        if(num[i]>maxNum){
                            tmp=i;
                            maxNum=num[i];
                        }
                    }
                }
            }
            myres.add(maxNum);
            j++;
        }
        return myres;
    }
}
