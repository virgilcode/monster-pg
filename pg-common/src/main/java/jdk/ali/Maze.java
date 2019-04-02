package jdk.ali;

import java.util.Scanner;

/**
 * @author Starstar Sun
 * @date 2018/9/6
 * @Description:
 **/
public class Maze {
    static int n, m, P;
    static int map[][] = new int[11][11];
    static int minPath[][] = new int[2][100];
    static int path[][] = new int[2][100];
    static int move[][] = new int[][]{{-1, 0, 3}, {0, 1, 1}, {1, 0, 0}, {0, -1, 1}};
    static int loseEnergy = 0;
    static int minLoseEnergy = Integer.MAX_VALUE;
    static int minSteps = 0;
    static int steps = 0;
    static int maxEnergy;

    public static void dfs(int row, int col, int[][] map) {
        if (row == 0 && col == m - 1 && P >= loseEnergy) {
            if (minLoseEnergy > loseEnergy) {
                minLoseEnergy = loseEnergy;
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < steps; j++) {
                        minPath[i][j] = path[i][j];
                    }
                }
                minSteps = steps;
            }
        }
        for (int i = 0; i < 4; i++) {
            int newRow = row + move[i][0];
            int newCol = col + move[i][1];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && map[newRow][newCol] == 1 && P >= loseEnergy) {
                steps++;
                path[0][steps] = newRow;
                path[1][steps] = newCol;
                map[newRow][newCol] = 0;
                loseEnergy += move[i][2];
                dfs(newRow, newCol, map);
                map[newRow][newCol] = 1;
                steps--;
                loseEnergy -= move[i][2];
            }
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        m = cin.nextInt();
        P = cin.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = cin.nextInt();
            }
        }

        cin.close();
        map[0][0] = 0;
        dfs(0, 0, map);
        if (minLoseEnergy == Integer.MAX_VALUE) {
            System.out.println("Can not escape!");
        } else {
            for (int i = 0; i < minSteps; i++) {
                System.out.print("[" + minPath[0][i] + "," + minPath[1][i] + "],");
            }
            System.out.print("[0," + (m - 1) + "]");
        }
    }
}
