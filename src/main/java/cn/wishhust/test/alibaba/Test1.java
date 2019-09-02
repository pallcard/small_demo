package cn.wishhust.test.alibaba;

import java.util.Scanner;

public class Test1 {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String getIndexAndLongest(String users) {
        final String[] s = users.split(" ");
        int k = Integer.parseInt(s[1]);
        int max = 0;
        int maxIndex = 0;
        int cur = 0;
        int curIndex = 0;
        for (int i = 0; i < s[0].length(); i++) {
            if (s[0].charAt(i) == 'b') {
                if (max < (cur = findNum(s[0], i))) {
                    max = cur;
                    maxIndex = i;
                }
            }


        }

        int [][]dp  = new int[k+1] [s[0].length()+1];

        int maxCount = 0;
        for (int i = 1; i < s[0].length(); i++) {
            if (s[0].charAt(i) == 'b') {
                dp[k][i] = dp[k][i-1]+1;
            } else if (k>0) {
                dp[k-1][i] = dp[k][i-1] + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(maxIndex + " ");
        sb.append(dp[0][s[0].length()]);
        return sb.toString();
    }

    public static int findNum(String users, int index) {
        int count = 0;
        int cur = index+1;
        while (users.charAt(cur%users.length()) == 'g') {
            count++;
            cur++;
        }
        if (cur%users.length() == index) {
            return count;
        }
        cur = index+users.length()-1;
        while (users.charAt(cur%users.length()) == 'g') {
            count++;
            cur = cur+users.length()-1;
        }
        return count;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }

        res = getIndexAndLongest(_users);
        System.out.println(res);
    }
}
