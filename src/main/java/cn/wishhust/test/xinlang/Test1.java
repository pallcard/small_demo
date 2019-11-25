package cn.wishhust.test.xinlang;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        final String[] s = str.split(", ");
        int mixIndex = 0;
        for (int i = 1; i < s.length; i++) {
            if (comp(s[i-1], s[i])) {
                mixIndex = i;
            }
        }
        System.out.println(s[mixIndex]);
    }

    public static boolean comp(String a, String b) {
        final String[] split1 = a.split("\\.");
        final String[] split2 = b.split("\\.");
        for (int i = 0; i < split1.length; i++) {
            if (Integer.parseInt(split1[i]) > Integer.parseInt(split2[i])) {
                return true;
            }
        }
        return false;
    }
}
