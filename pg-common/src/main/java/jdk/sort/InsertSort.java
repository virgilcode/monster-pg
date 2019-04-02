package jdk.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author Starstar Sun
 * @date 2018/7/3120:58
 * @Description:
 **/
public class InsertSort {

    public void sort(int[] nums) {
        int temp = 0, size = nums.length;
        if (size >= 1) {
            for (int i = 1; i < size; i++) {
                temp = nums[i];
                int j = i - 1;
                while (j >= 0 && temp < nums[j]) {
                    nums[j + 1] = nums[j];
                    j--;
                }
                nums[j + 1] = temp;
            }

        }

    }

    public  int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        int[] a = {-2, 0, -2, 1, 5, 21, 45, 23, -8};
        System.out.println(JSON.toJSONString(a));
        sort.insertionSort(a);
        System.out.println(JSON.toJSONString(a));
    }
}
