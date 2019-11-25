package cn.wishhust.test.zijie;

import java.util.*;

public class Test4 {

    private static Map<String,Character> map = new HashMap<>();
    static {
        for (int i = 1; i <= 26; i++) {
            map.put("" + i, (char)('A'+i-1));
        }
    }
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        StringBuilder sb = new StringBuilder();
//        dps(str, sb);
        List<Test4> list = new ArrayList<>();
        while (true) {
            list.add(new Test4());
        }
    }

    public static void dps(String str, StringBuilder sb) {
        if (str.length() == 0) {
            System.out.println(sb.toString());
            return;
        }
        // 1个数
        if (str.length() > 1 && str.charAt(1) == '0') {

        } else {
            dps(str.substring(1), sb.append(map.get(str.substring(0,1))));
            sb.delete(sb.length()-1,sb.length());
        }
        // 2个数
        if (str.length() > 1 && Integer.parseInt(str.substring(0,2))<=26) {
            dps(str.substring(2), sb.append(map.get(str.substring(0,2))));
            sb.delete(sb.length()-1,sb.length());
        }
    }
}
