package cn.wishhust.algorithm;

/**
 * 矩阵中的路径
 * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向上下左右移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * a b c e
 * s f c s
 * a d e e
 */
public class Demo012 {

    public static void main(String[] args) {
        char[] matrix = new char[]{'b', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        int rows = 3;
        int cols = 4;
        char [] target = new char[]{'b','f','c','e'};

        char[][] array = new char[3][4];
        int index = 0;
        int x = 0, y = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = matrix[index++];

            }
        }

        boolean result = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == target[0]) {
                    result = search(array,i,j,target,1);
                    if (result) {
                        System.out.println(result);
                        return;
                    }
                }
            }
        }

        System.out.println(result);

    }
    // 左 上 右 下
    public static int [][] direct = new int [][]
            {{0,-1},{-1,0},{0,1},{1,0}};

    public static boolean search(char[][] array, int x, int y, char [] target, int index) {
        for (int i = 0; i < 4; i++) {
            if (x + direct[i][0] >= 0
                    && x + direct[i][0] < 3
                    && y + direct[i][1] >= 0
                    && y + direct[i][1] < 4) {
                x += direct[i][0];
                y += direct[i][1];
                if (array[x][y] == target[index] && target.length == index+1) {
                    return true;
                } else if (array[x][y] == target[index]) {
                    return search(array,x,y,target,++index);
                }
                // x,y 坐标还原
                x -= direct[i][0];
                y -= direct[i][1];
            }
        }
        return false;
    }
}
