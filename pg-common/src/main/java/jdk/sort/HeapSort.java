package jdk.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author Starstar Sun
 * @date 2019/3/3
 * @Description:堆排序 http://www.cnblogs.com/jingmoxukong/p/4303826.html
 **/
public class HeapSort {

    public void heapAdjust(int[] array, int parent, int length) {
        int temp = array[parent]; // temp保存当前父节点
        int child = 2 * parent + 1; // 先获得左孩子

        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= array[child])
                break;

            // 把孩子结点的值赋给父结点
            array[parent] = array[child];

            // 选取孩子结点的左孩子结点,继续向下筛选 因为堆是一个完全二叉树？
            parent = child;
            child = 2 * child + 1;
        }

        array[parent] = temp;
    }

    public void heapSort(int[] list) {
        // 循环建立初始堆
        // ?从非叶子节点开始的？
        for (int i = list.length / 2; i >= 0; i--) {
            heapAdjust(list, i, list.length);
        }

        System.out.format("第 %d 趟: \t", 0);
        printPart(list, 0, list.length - 1);

        // 进行n-1次循环，完成排序
        for (int i = list.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;

            // 筛选 R[0] 结点，得到i-1个结点的堆
            heapAdjust(list, 0, i);
//            System.out.format("第 %d 趟: \t", list.length - i);
//            printPart(list, 0, list.length - 1);
        }
    }

    // 打印序列
    public void printPart(int[] list, int begin, int end) {
        for (int i = 0; i < begin; i++) {
            System.out.print("\t");
        }
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
    }


//    public int[] sort(int[] arr) {
//        int size = arr.length;
//        buildHeap(arr);
//        for(int j=size-1;j>0;j--){
//            swap(arr,0,j);
//            adjust(arr,0,j);
//        }
//        return  arr;
//    }
//
//    public void buildHeap(int[] arr) {
//        int len = arr.length;
//        for(int i=len/2-1;i>=0;i--){
//            adjust(arr,i,len);
//        }
//
//    }
//
//    public void adjust(int[] array, int i, int length) {
//        int maxIndex = i;
//        // 先把当前元素取出来，因为当前元素可能要一直移动
//        int temp = array[i];
//        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
//            // 让k先指向子节点中最大的节点
//            if (k + 1 < length && array[k] < array[k + 1]) {
//                k++;
//            }
//            // 如果发现子节点更大，则进行值的交换
//            if(array[k]>temp){
//                swap(array,i,k);
//                i=k;
//            }else{
//                break;
//            }
//        }
//
//
//    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] a = {-2, 0, -2, 1, 5, 21, 45, 23, -8};
//        int[] a = {1,3,4,5,2,6,9,7,8,0};
        System.out.println(JSON.toJSONString(a));
        sort.heapSort(a);
        System.out.println(JSON.toJSONString(a));
    }
}
