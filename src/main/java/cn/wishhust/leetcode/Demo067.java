package cn.wishhust.leetcode;

public class Demo067 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int d = 0;
        while (i>=0 || j>=0) {
            int t;
            if (i>=0 && j >= 0) {
                t = d + (a.charAt(i)-'0')+(b.charAt(j)-'0');
            } else if (i>=0) {
                t = d + (a.charAt(i)-'0');
            } else {
                t = d + (b.charAt(j)-'0');
            }
            d = t / 2;
            sb.append(t % 2);
            i--;j--;
        }
        if (d == 1) {
            sb.append(d);
        }
        return sb.reverse().toString();
    }
}
