package jdk.ali;

import java.util.Scanner;

public class Main {
    public static int compare(long num1, long num2) {
        String str1 = num1 + "";
        String str2 = num2 + "";
        int temp1 = Integer.parseInt(str1 + str2);
        int temp2 = Integer.parseInt(str2 + str1);

        return temp1 - temp2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        long temp = 0;

        for (int j = 0; j < n; j++) {
            a[j] = sc.nextLong();
        }

        for (int x = 0; x < n; x++) {
            for (int y = x + 1; y < n; y++) {
                if (compare(a[x], a[y]) < 0)
                {
                    temp = a[x];
                    a[x] = a[y];
                    a[y] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
        }
    }
}
