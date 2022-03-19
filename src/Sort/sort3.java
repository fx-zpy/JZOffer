package Sort;

import java.util.*;

/**
 * JZ40 最小的K个数
 * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。
 * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
 *
 */
public class sort3 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(input==null||k>input.length||k==0){
            return arr;
        }
//        int temp;
//        for (int i = 0; i <input.length-1 ; i++) {
//            for (int j = i+1; j <input.length ; j++) {
//                if(input[j]<input[i]){
//                    temp=input[i];
//                    input[i]=input[j];
//                    input[j]=temp;
//                }
//            }
//        }
        /**
         * 排序函数yyds，有了这个还写啥冒泡排序啊。
         */
        Arrays.sort(input);
        for (int i = 0; i <k ; i++) {
            arr.add(input[i]);
        }
        return arr;
    }

    /**
     * 最大堆解法
     */
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>(k);
        //根据题意要求，如果K>数组的长度，返回一个空的数组
        if (k > input.length || k == 0) {
            return res;
        }
        //创建最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        //先在堆中放数组的前k个元素
        for (int i = 0; i < k; ++i) {
            queue.offer(input[i]);
        }
        //因为是最大堆，也就是堆顶的元素是堆中最大的，遍历数组后面元素的时候，
        //如果当前元素比堆顶元素大，就把堆顶元素给移除，然后再把当前元素放到堆中，
        for (int i = k; i < input.length; ++i) {
            if (queue.peek() > input[i]) {
                queue.poll();
                queue.offer(input[i]);
            }
        }
        //最后再把堆中元素转化为数组
        for (int i = 0; i < k; ++i) {
            res.add(queue.poll());
        }
        return res;
    }

    /**
     * Treemap解法
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>(k);
        //根据题意要求，如果K>数组的长度，返回一个空的数组
        if (k > input.length || k == 0) {
            return res;
        }
        //map中key存放数组中元素，value存放这个元素的个数
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            //map中先存放k个元素，之后map中元素始终维持在k个
            if (count < k) {
                map.put(input[i], map.getOrDefault(input[i], 0) + 1);
                count++;
                continue;
            }
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            //从第k+1个元素开始，每次存放的时候都要和map中最大的那个比较，如果比map中最大的小，
            //就把map中最大的给移除，然后把当前元素加入到map中
            if (entry.getKey() > input[i]) {
                //移除map中最大的元素，如果只有一个直接移除。如果有多个（数组中会有重复的元素），移除一个就行
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
                //把当前元素加入到map中
                map.put(input[i], map.getOrDefault(input[i], 0) + 1);
            }
        }

        //把map中key存放到集合list中
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int keyCount = entry.getValue();
            while (keyCount-- > 0) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    /**
     * 快排
     */
    public ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>(k);
        //根据题意要求，如果K>数组的长度，返回一个空的数组
        if (k > input.length || k == 0) {
            return res;
        }
        quickSort(input, res, k, 0, input.length - 1);
        return res;
    }

    private void quickSort(int[] input, ArrayList<Integer> res, int k, int left, int right) {
        //快排的实现方式有多种，我们选择了其中的一种
        int start = left;
        int end = right;
        while (left < right) {
            while (left < right && input[right] >= input[start]) {
                right--;
            }
            while (left < right && input[left] <= input[start]) {
                left++;
            }
            swap(input, left, right);
        }
        swap(input, left, start);
        //注意这里，start是数组中元素的下标。在start之前的元素都是比start指向的元素小，
        //后面的都是比他大。如果k==start，正好start之前的k个元素是我们要找的，也就是
        //数组中最小的k个，如果k>start，说明前k个元素不够，我们还要往后再找找。如果
        //k<start，说明前k个足够了，我们只需要在start之前找k个即可。
        if (left > k) {
            quickSort(input, res, k, start, left - 1);
        } else if (left < k) {
            quickSort(input, res, k, left + 1, end);
        } else {
            //取前面的k个即可
            for (int m = 0; m < k; ++m) {
                res.add(input[m]);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
