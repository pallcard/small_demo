package cn.wishhust.test.zijie;

import java.util.Scanner;

public class Test3 {

    public static int fun(String[] space, int left, int right) {
        String [] map = new String [right-left+1];
        for (int i = 0; i < map.length; i++) {
            map[i] = space[left+i];
        }
        int dir = 0;
        int index = 0;
        int score = 0;
        while (index >= 0 || index < map.length) {
            if (map[index].length() <= 0) {
                if (dir == 0) {
                    index++;
                } else {
                    index--;
                }
                continue;
            }

            if (map[index].charAt(0) == '>'){
                if (dir == 0 && index-1>=0 && (map[index-1].charAt(0) == '>' || map[index-1].charAt(0) == '<')) {
                    map[index] = "";
                }
                if (dir == 1 && index+1<map.length && (map[index+1].charAt(0) == '>' || map[index+1].charAt(0) == '<')) {
                    map[index] = "";
                }
                dir = 0;
                index++;
                continue;
            }

            if (map[index].charAt(0) == '<') {
                if (dir == 0 && index-1>=0 && (map[index-1].charAt(0) == '>' || map[index-1].charAt(0) == '<')) {
                    map[index] = "";
                }
                if (dir == 1 && index+1<map.length && (map[index+1].charAt(0) == '>' || map[index+1].charAt(0) == '<')) {
                    map[index] = "";
                }
                dir = 1;
                index--;
                continue;
            }
            if (Integer.parseInt(map[index]) == 0) {
                map[index] = "";
            } else {
                score += Integer.parseInt(map[index]);
                map[index] = Integer.parseInt(map[index])-1+"";
            }
            if (dir == 0) {
                index++;
            } else {
                index--;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m, q;
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        String[] space = str.split(" ");
        int [][] di = new int[q][2];
        for (int i = 0; i < q; i++) {
            di[i][0] = scanner.nextInt();
            di[i][1] = scanner.nextInt();
            System.out.println(fun(space, di[i][0]-1, di[i][1]-1));
        }
    }
}
