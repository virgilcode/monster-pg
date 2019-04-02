package jdk.ali;

import java.util.Scanner;

/**
 * @author Starstar Sun
 * @date 2018/9/6
 * @Description:
 **/
public class Demo2 {
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
//        int x = 73;
//        int y = 23;
//        int p = 5;
//        int n = 3;
//        int r = demo2.setbits(x, p, n, y);
//        System.out.println(r);

        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();//n行
        int m = cin.nextInt();//m列
        int P = cin.nextInt();
        int map[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = cin.nextInt();
            }
        }
        cin.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                map[i][j] = cin.nextInt();
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }


    }

    int setbits(int x, int p, int n, int y) {
        return x & ~(~(~0 << n) << (p + 1 - n)) | (y & ~(~0 << n)) << (p + 1 - n);
    }


}
