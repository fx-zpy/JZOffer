package Other;

/**
 * JZ49 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第 n个丑数。
 */
public class o8 {



            public int GetUglyNumber_Solution(int index) {
                //很明显，丑数除了2,3,5之外其他丑数肯定都是由丑数乘来的，不是丑数的数乘啥都不会变成丑数
                //那么丑数就会分成三种，一种是乘2来的，一种是乘3来的，一种是乘5来的
                //所以解法就变成了将这三种类型的丑数进行一个递增数组的合并，找出第n个来
                //2
                //[1*2,2*2,3*2,4*2,5*2...]
                //3
                //[1*3,2*3,3*3,4*3,5*3...]
                //5
                //[1*5,2*5,3*5,4*5,5*5...]
                //不过这里可能出现重复值的情况，所以需要进行去重，可以发现出现重复的时候肯定是在同一时间比如3*2和2*3
                if(index<=0) {
                    return 0;
                }
                int N = index;
                int[] dp = new int[N];
                dp[0] = 1;
                int t2Ptr = 0,t3Ptr = 0,t5Ptr = 0;
                for(int i = 1;i<N;i++){
                    int t2Res = dp[t2Ptr] * 2;
                    int t3Res = dp[t3Ptr] * 3;
                    int t5Res = dp[t5Ptr] * 5;
                    dp[i] = Math.min(t2Res,Math.min(t3Res,t5Res));
                    if(t2Res==dp[i]) {
                        t2Ptr++;
                    }
                    if(t3Res==dp[i]) {
                        t3Ptr++;
                    }
                    if(t5Res==dp[i]) {
                        t5Ptr++;
                    }
                }
                return dp[N-1];

            }
            //2.最小堆解法,从最小的丑数起，每次将最小的那个弹出来分别*2，*3，*5放回堆里，这样按照顺序不会漏掉所有的丑数

    /*public int GetUglyNumber_Solution(int index) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.add(1L);
        //每次弹出最小的时候肯定这个值能生成的可能性都考虑到了，因为之后弹出的都会>=这个数，*2,3,5之后必然比这个数大
        //所以弹出的时候循环弹，将相同的全弹出来就可以避免重复了
        long num = 0;
        while(index>0){
            while((num = minHeap.poll())>0&&(!minHeap.isEmpty()&&num == minHeap.peek()));
            minHeap.add(num*2);
            minHeap.add(num*3);
            minHeap.add(num*5);
            index--;
        }
        return (int)num;
    }*/
            //3.需要去重，还想要排序，这肯定考虑一下TreeSet
//     public int GetUglyNumber_Solution(int index) {
//         TreeSet<Long> minHeap = new TreeSet<>();
//         minHeap.add(1L);
//         long num = 0;
//         while(index>0){
//             index--;
//             num = minHeap.pollFirst();
//             minHeap.add(num*2);
//             minHeap.add(num*3);
//             minHeap.add(num*5);
//         }
//         return (int)num;
//     }
        }


