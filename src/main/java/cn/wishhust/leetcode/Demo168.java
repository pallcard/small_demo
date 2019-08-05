package cn.wishhust.leetcode;
public class Demo168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            // 对n取余后为0-25，通过n--使得下标正常。
            n--;
            char c = (char) ((n%26)+'A');
            sb.append(c);
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println((char)('A'+1));
    }

}
