package cn.wishhust.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 93. 复原IP地址
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * dfs
 *
 */
public class Demo093 {

//    public static List<String> restoreIpAddresses(String s) {
//        List<String> list = new ArrayList<>();
//        if (s.length() < 4) {
//            return list;
//        }
//        StringBuilder sb = new StringBuilder(s);
//
//        // 1234
//        for (int i = 1; i < sb.length() - 2; i++) {
//            // 1.234
//            sb.insert(i, ".");
//            for (int j = i + 2; j < sb.length() - 1; j++) {
//                // 1.2.34
//                sb.insert(j, ".");
//                for (int k = j + 2; k < sb.length(); k++) {
//                    // 1.2.3.4
//                    sb.insert(k,".");
//                    list.add(sb.toString());
//                    sb.deleteCharAt(k);
//                }
//                sb.deleteCharAt(j);
//            }
//            sb.deleteCharAt(i);
//        }
//
//        for (int i = list.size()-1; i >= 0; i--) {
//            String[] split = list.get(i).split("\\.");
//            for (int j = 0; j < split.length; j++) {
//                if (split[j].length()>3 || Integer.parseInt(split[j]) > 255) {
//                    list.remove(i);
//                    break;
//                }
//            }
//        }
//
//
//        return list;
//    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 4) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        restoreIpAddresses(s, list, sb, 0);
        return list;

    }
    // s = 12345
    // 1.  1
    // 1.2. 2
    // 1.2.3. 3
    // 1.2.3.4. 4
    public static void restoreIpAddresses(String s, List<String> list, StringBuilder sb, int k) {
        if (k == 4 && s.length() == 0) {
//            sb.deleteCharAt(sb.length()-1);
            list.add(sb.toString());
            return;
        }
        if (k == 4) {
            return;
        }
        for (int i = 0; i < s.length() && i <=2; i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
//            if (Integer.parseInt(s.substring(0, i+1)) <= 255) {
//                sb.append(s.substring(0, i+1));
//                sb.append(".");
//                restoreIpAddresses(s.substring(i+1), list, sb, k+1);
//                sb.delete(sb.length()-i-2, sb.length());
//            }
            String part = s.substring(0, i+1);
            if (Integer.parseInt(part) <= 255) {
                if (sb.length() != 0) {
                    part = "."+part;
                }
                sb.append(part);
                restoreIpAddresses(s.substring(i+1),list,sb,k+1);
                sb.delete(sb.length()-part.length(),sb.length());
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("010010"));
//        System.out.println("010010");
    }
}
