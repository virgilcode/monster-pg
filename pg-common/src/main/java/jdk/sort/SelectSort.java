package jdk.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author Starstar Sun
 * @date 2018/7/3120:52
 * @Description: https://www.cnblogs.com/guoyaohua/p/8600214.html
 **/
public class SelectSort {



    public  int[] sort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        SelectSort sort = new SelectSort();
        int[] a = {-2, 0, -2, 1, 5, 21, 45, 23};
        System.out.println(JSON.toJSONString(a));
        sort.sort(a);
        System.out.println(JSON.toJSONString(a));
    }
}
