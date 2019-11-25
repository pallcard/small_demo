package cn.wishhust.test.baidu;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int count = 0;
        int [][] money = new int[n][2];
        int index = 0;
        int moneyCount = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x >= m) {
                count += y;
            } else {
                money[index][0] = x;
                money[index][1] = y;
                index++;
                moneyCount +=y;
            }
        }
        Arrays.sort(money[0]);
        while (moneyCount>0) {
            System.out.println(moneyCount);
            moneyCount--;
        }
    }
}
