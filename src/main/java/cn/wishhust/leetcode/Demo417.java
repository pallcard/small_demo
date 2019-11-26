package cn.wishhust.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 417. 太平洋大西洋水流问题
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 *
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 *
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 *  
 *
 * 提示：
 *
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *
 *
 */
public class Demo417 {

    public static int [][] direct = new int [][]{{0,-1},{-1,0},{0,1},{1,0}};

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> list = new ArrayList<>();

        if (matrix.length == 0) {
            return list;
        }

        boolean [][] left = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            left[0][i] = true;
            pacificAtlantic(matrix, left, 0, i);

        }

        for (int i = 0; i < matrix.length; i++) {
            left[i][0] = true;
            pacificAtlantic(matrix, left, i, 0);
        }

        boolean [][] right = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            right[matrix.length-1][i] = true;
            pacificAtlantic(matrix, right, matrix.length-1, i);


        }

        for (int i = 0; i < matrix.length; i++) {
            right[i][matrix[0].length-1] = true;
            pacificAtlantic(matrix, right, i, matrix[0].length-1);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (left[i][j] && right[i][j]) {
                    list.add(Arrays.asList(i,j));
                }
            }
        }

        return list;
    }

    public static void pacificAtlantic(int[][] matrix, boolean[][] left, int x, int y) {

        for (int i = 0; i < 4; i++) {
            int x1 = x+direct[i][0], y1 = y+direct[i][1];
            if (x1 >= 0 && x1 < matrix.length
                    && y1 >= 0 && y1 < matrix[0].length
                    && matrix[x1][y1] >= matrix[x][y] && !left[x1][y1]) {
                left[x1][y1] = true;
                pacificAtlantic(matrix, left, x1, y1);
            }

        }
    }


//    public static void atlantic(int[][] matrix, boolean[][] left, int x, int y) {
//        for (int i = 0; i < 4; i++) {
//            int x1 = x+direct[i][0], y1 = y+direct[i][1];
//            if (x1 >= 0 && x1 < matrix.length
//                    && y1 >= 0 && y1 < matrix[0].length
//                    && matrix[x1][y1] >= matrix[x][y] && left[x1][y1]) {
//                list.add(Arrays.asList(x1,y1));
//                pacific(matrix, left, x1, y1);
//            }
//
//        }
//    }

    public static void main(String[] args) {

        System.out.println(pacificAtlantic(new int [][] {
                {1,1,1},
                {1,1,1},
                {1,1,1},
//                {1,2,2,3,5},
//                {3,2,3,4,4},
//                {2,4,5,3,1},
//                {6,7,1,4,5},
//                {5,1,1,2,4}
        }));
    }

}
