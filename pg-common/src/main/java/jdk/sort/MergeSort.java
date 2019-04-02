package jdk.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author Starstar Sun
 * @date 2018/7/31 23:09
 * @Description:https://blog.csdn.net/jianyuerensheng/article/details/51262984
 **/
public class MergeSort {
    public void sort(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            sort(nums, left, mid);
            sort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }

    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1;
        int t = 0;//临时数组指针
        //较小的数先放到数组中
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        //剩余数据移到数组
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= right) {
            temp[t++] = nums[j++];
        }
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[left + k2] = temp[k2];
        }


    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] a = {-2, 0, -2, 1, 5, 21, 45, 23, -8};
        System.out.println(JSON.toJSONString(a));
        sort.sort(a, 0, a.length - 1);
        System.out.println(JSON.toJSONString(a));
    }
}
