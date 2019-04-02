package jdk.sort;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Starstar Sun
 * @date 2018/7/31 22:39
 * @Description:
 **/
public class QuickSort {
    public void sort(int[] nums, int low, int high) {
        if (low < high) {
            int midle = getMiddle(nums, low, high);
            sort(nums, low, midle-1);
            sort(nums, midle + 1, high);
        }

    }

    public int getMiddle(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            while (low < high && nums[high] > temp) {
                high--;
            }
            if (low < high) {
                nums[low++] = nums[high];
            }
            while (low < high && nums[low] < temp) {
                low++;
            }
            if (low < high) {
                nums[high--] = nums[low];
            }
        }
        nums[low] = temp;
        return low;
    }

    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        int n=cin.nextInt();
//        int k=cin.nextInt();
//        int[] arr=new int[n];
//        HashMap<Integer,Integer> map=new HashMap();
//
//        for(int i=0;i<n;i++){
//            arr[i]=cin.nextInt();
//            map.put(arr[i],i);
//        }
//        cin.close();
//        int[] arr2=arr;

//        int[] arr = {-2, 0, -2, 1, 5, 21, 45, 23};
//
//        QuickSort sort = new QuickSort();
//        sort.sort(arr,0,arr.length-1);
//        System.out.println(JSON.toJSONString(arr));
//        for(int i=0;i<k;i++){
//            System.out.println(arr[i]);
//        }

        QuickSort sort = new QuickSort();
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(JSON.toJSONString(a));
        sort.sort(a, 0, a.length - 1);
        System.out.println(JSON.toJSONString(a));


    }
}
