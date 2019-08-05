package cn.wishhust.algorithm;

/**
 * 机器人的运动范围
 *
 * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 *
 * 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
 *
 */
public class Demo013 {

    // 左 上 右 下
    public static int [][] direct = new int [][]
            {{0,-1},{-1,0},{0,1},{1,0}};

    public static int count = 0;
    public static int m = 11;
    public static int n = 11;
    public static int k = 10;


    public static void main(String[] args) {
        int [][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int i_temp = i;
                int j_temp = j;
                // 处理数位
                int i_sum = i_temp%10;
                int j_sum = j_temp%10;

                i_temp /= 10;
                j_temp /= 10;
                while (i_temp > 0){
                    i_sum += i_temp%10;
                    i_temp /= 10;
                }
                while (j_temp > 0) {
                    j_sum += j_temp%10;
                    j_temp /= 10;
                }
                array[i][j] = i_sum+j_sum;
            }
        }
        count++;
        array[0][0] = k + 1;
        DPsearch(array,0,0);
        System.out.println(count);
    }



    public static void DPsearch(int [][] array, int x, int y) {
        for (int i = 0; i < 4; i++) {
            if (x + direct[i][0] >= 0
                    && x + direct[i][0] < m
                    && y + direct[i][1] >= 0
                    && y + direct[i][1] < n) {
                x += direct[i][0];
                y += direct[i][1];

                if(array[x][y] <= k) {
                    // 走过的格子失效
                    array[x][y] = k + 1;
                    count++;
                    DPsearch(array,x,y);
                }

                // x,y 坐标还原
                x -= direct[i][0];
                y -= direct[i][1];
            }
        }
    }
}
