package cn.wishhust.leetcode;

/**
 *
 * 200. ��������
 *
 * ����һ����?'1'��½�أ��� '0'��ˮ����ɵĵĶ�ά���񣬼��㵺���������һ������ˮ��Χ����������ͨ��ˮƽ�����ֱ���������ڵ�½�����Ӷ��ɵġ�����Լ���������ĸ��߾���ˮ��Χ��
 *
 * ʾ�� 1:
 *
 * ����:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * ���:?1
 * ʾ��?2:
 *
 * ����:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * ���: 3
 *
 *
 */
public class Demo200 {

    public static int [][] direct = new int [][]{{0,-1},{-1,0},{0,1},{1,0}};

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    findByDFS(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public static void findByDFS(int x, int y, char [][] grid) {
        if (x < 0 || x >= grid.length
                || y < 0 || y >= grid[0].length
                || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';


        for (int i = 0; i < direct.length; i++) {
            int prex = x + direct[i][0];
            int prey = y + direct[i][1];
            findByDFS(prex, prey, grid);
        }
    }

}
