package main.java.cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo417 {

    public static int [][] direct = new int [][]{{0,-1},{-1,0},{0,1},{1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            list.add(Arrays.asList(0, i));
            list.add(Arrays.asList(i, 0));
        }

        boolean [][] left = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            left[0][i] = true;
            pacific(matrix,0, i);
            left[i][0] = true;
            pacific(matrix, i, 0);
        }


        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (i-1 >= 0 && matrix[i][j] > matrix[i-1][j] && left[i-1][j]) {
                    left[i][j] = true;
                } else (j-1 >= 0 && matrix[i][j] > matrix[i][j-1] && left[i][j-1])  {

                }
//                matrix[i][j] = matrix[i-1][j] || matrix[i][j-1];
            }
        }
    }

    public List<List<Integer>> pacific(int[][] matrix, int x, int y) {


        for (int i = 0; i < 4; i++) {

        }
    }


    public List<List<Integer>> atlantic(int[][] matrix, int x, int y) {

    }

}
