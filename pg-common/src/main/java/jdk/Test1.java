package jdk;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Starstar Sun
 * @date 2018/8/7 18:13
 * @Description:
 **/
public class Test1 {

    private static List<Integer> list = new ArrayList<>();

    public void add(Integer a){
        list.add(a);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(list);
    }

    public static void intersection(int array1[], int array2[]) {
        int M = array1.length;
        int N = array2.length;
        int i = 0, j = 0;
        while (i < M && j < N) {
            System.out.println("i:" + i + array1[i] + "---" + "j:" + j + array2[j]);
            while (array1[i] < array2[j]) {

                i++;
            }
            while (array1[i] > array2[j]) {
                j++;
            }
            while (array1[i] == array2[j]) {
                System.out.println("相同的数：" + array1[i]);
                if (i == M - 1 || j == N - 1) {
                    System.out.println(i);
                    return;
                } else {
                    i++;
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] array1 = {1, 2, 5, 6, 99, 33, 44};
//        int[] array2 = {2, 3, 6, 99, 22, 11};
//        intersection(array1, array2);

        Test1 test1_1 = new Test1();
        test1_1.add(1);
        test1_1.add(2);
        Test1 test1_2 = new Test1();
        System.out.println(test1_1);
        System.out.println(test1_2);
    }
}
