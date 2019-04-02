package jdk.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author Starstar Sun
 * @date 2018/7/3122:08
 * @Description:
 **/
public class ShellSort {
    public void sort(int[] nums) {
        int temp = 0, size = nums.length, j = 0;
        if (size >= 1) {
            for (int increment = size / 2; increment > 0; increment /= 2) {
                for (int i = increment; i < size; i++) {
                    temp = nums[i];
                    for (j = i - increment; j >= 0; j -= increment) {
                        if (temp < nums[j]) {
                            nums[j + increment] = nums[j];
                        } else {
                            break;
                        }
                    }
                    nums[j + increment] = temp;
                }

            }

        }

    }

    public int[] shellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        int[] a = {-2, 0, -2, 1, 5, 21, 45, 23, -8};
        System.out.println(JSON.toJSONString(a));
        sort.shellSort(a);
        System.out.println(JSON.toJSONString(a));
    }
}
