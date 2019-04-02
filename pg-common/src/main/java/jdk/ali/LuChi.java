package jdk.ali;

/**
 * @author Starstar Sun
 * @date 2018/9/6
 * @Description:
 **/
public class LuChi {
    /**
     * 定义迷宫数组
     */
    private int[][] array = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}

    };
    private int maxLine = 6;
    private int maxRow = 5;


    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        new LuChi().check(0, 0);
        System.out.println(System.currentTimeMillis());
    }

    private void check(int i, int j) {
        //如果到达右下角出口
        if (i == maxRow - 1 && j == maxLine - 1) {
            print();
            return;
        }

        //向右走
        if (canMove(i, j, i, j + 1)) {
            array[i][j] = 2;
            check(i, j + 1);
            array[i][j] = 0;
        }
        //向左走
        if (canMove(i, j, i, j - 1)) {
            array[i][j] = 2;
            check(i, j - 1);
            array[i][j] = 0;
        }
        //向下走
        if (canMove(i, j, i + 1, j)) {
            array[i][j] = 2;
            check(i + 1, j);
            array[i][j] = 0;
        }
        //向上走
        if (canMove(i, j, i - 1, j)) {
            array[i][j] = 2;
            check(i - 1, j);
            array[i][j] = 0;
        }
    }

    private boolean canMove(int i, int j, int targetI, int targetJ) {
//        System.out.println("从第" + (i + 1) + "行第" + (j + 1) + "列，走到第" + (targetI + 1) + "行第" + (targetJ + 1) + "列");
        if (targetI < 0 || targetJ < 0 || targetI >= maxRow || targetJ >= maxLine) {
//            System.out.println("到达最左边或最右边，失败了");
            return false;
        }
        //避免在两个空格间来回走
        //2表示这个路走过了
        if (array[targetI][targetJ] == 2) {
//            System.out.println("来回走，失败了");
            return false;
        }
        return true;
    }

    private void print() {
        System.out.println("得到一个解：");
        int step = 0;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxLine; j++) {
                System.out.print(array[i][j] + " ");
                if (array[i][j] == 2) {
                    step++;
                }
            }
            System.out.println();
        }
        System.out.println("总共花了" + step + "步");
    }
}
