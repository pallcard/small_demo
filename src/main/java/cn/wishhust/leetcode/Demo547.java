package main.java.cn.wishhust.leetcode;

public class Demo547 {

//    public static int [][] direct = new int [][]{{0,-1},{-1,0},{0,1},{1,0}};
//    public static int findCircleNum(int [][] M) {
//        int count = 0;
//        for (int i = 0; i < M.length; i++) {
//            for (int j = 0; j < M[0].length; j++) {
//                if (M[i][j] != 0) {
//                    count++;
//                    findCircleNum(M,i,j);
//                }
//            }
//        }
//        return count;
//    }
//
//    public static void findCircleNum(int [][] M, int x, int y) {
//        if (x < 0 || x >= M.length || y < 0 || y >= M[0].length || M[x][y] == 0) {
//            return;
//        }
//        M[x][y] = 0;
//        for (int i = 0; i < 4; i++) {
//            findCircleNum(M, x+direct[i][0], y+direct[i][1]);
//        }
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println(findCircleNum(new int [][]{
//                {1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}
//        }));
//    }


    public static int findCircleNum(int[][] M) {
        boolean [] visited  = new boolean [M.length];
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                count++;
                findCircleNum(M, visited, i);
            }
        }
        return count;
    }


    public static void findCircleNum(int [][] M, boolean [] visited, int x) {
        visited[x] = true;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i] && M[i][x] == 1) {
                findCircleNum(M, visited, i);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int [][]{
                {1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}
        }));
    }



}
