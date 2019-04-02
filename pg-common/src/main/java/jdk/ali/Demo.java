package jdk.ali;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int r[] = findKthNumbers(a, n, k);
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }

    public static int[] findKthNumbers(int[] arr, int n, int k) {

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        int min[] = new int[k];
        for (int i = 0; i < k; i++) {
            min[i] = a[i];
        }
        int r[] = new int[k];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        while (list.size() > k) {
            for (int j = 0; j < list.size(); j++) {
                if (isContain(list.get(j), min) == false) {
                    list.remove(j);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            r[i] = list.get(i);
        }
        return r;
    }

    public static boolean isContain(int d, int min[]) {
        for (int i = 0; i < min.length; i++) {
            if (d == min[i]) {
                return true;
            }
        }
        return false;
    }
}
