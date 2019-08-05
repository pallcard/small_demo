package cn.wishhust.leetcode;
public class Demo504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        String symbol = "";
        if (num < 0) {
            symbol = "-";
            num = 0 - num;
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int n = num % 7;
            num = num / 7;
            sb.append(n);
        }
        return symbol + sb.reverse().toString();

    }
}
