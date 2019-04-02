package jdk.sort;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Starstar Sun
 * @date 2019/3/3
 * @Description:桶排序
 **/
public class BucketSort {

    public ArrayList<Integer> sort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1)
                    bucketSize--;
                ArrayList<Integer> temp = sort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }

            // 以下为取巧
//            Collections.sort(bucketArr.get(i));
//            for (int j = 0; j < bucketArr.get(i).size(); j++)
//                    resultArr.add(bucketArr.get(i).get(j));
        }

        return resultArr;
    }

    public static void main(String[] args) {
        BucketSort sort = new BucketSort();
        int[] a = {-2, 0, -2, 1, 5, 21, 45, 23, -8};
        ArrayList list = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }

        System.out.println(JSON.toJSONString(list));

        ArrayList res = sort.sort(list, a.length);
        System.out.println(JSON.toJSONString(res));
    }
}
