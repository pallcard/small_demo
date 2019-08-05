package cn.wishhust.leetcode;
public class Demo415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int d = 0;
        while (i>=0 || j>=0) {
            int t;
            if (i>=0 && j >= 0) {
                t = d + (num1.charAt(i)-'0')+(num2.charAt(j)-'0');
            } else if (i>=0) {
                t = d + (num1.charAt(i)-'0');
            } else {
                t = d + (num2.charAt(j)-'0');
            }
            d = t / 10;
            sb.append(t % 10);
            i--;j--;
        }
        if (d > 0) {
            sb.append(d);
        }
        return sb.reverse().toString();
    }

}
