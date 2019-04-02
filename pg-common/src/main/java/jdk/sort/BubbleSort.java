package jdk.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author Starstar Sun
 * @date 2018/7/3120:40
 * @Description:
 **/
public class BubbleSort {

    public void sort(int[] nums) {
        int temp = 0, size = nums.length;
        boolean sorted = false;
        for (int i = 0; i < size - 1 && !sorted; i++) {
            sorted = true;
            for (int j = 0; j < size - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    sorted = false;
                }
            }
        }

    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] a = {-2, 0, -2, 1, 5, 21, 45, 23};
        System.out.println(JSON.toJSONString(a));
        sort.sort(a);
        System.out.println(JSON.toJSONString(a));
    }
}
