package cn.wishhust.test;

import java.awt.image.Kernel;

public class WangYi03 {
    public static void main(String[] args) {
        String s = "NNNGGNNGGGNNNNNNNNNNNNN";
        int prepre= 0;
        int pre = 0;
        int cur = 0;
        int used = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'N') {
                cur++;
            }else {
                if (used < 2) {
                    used++;
                }
                prepre = pre;
                pre = cur;
                cur = 0;
            }
            max = Math.max(max, prepre+pre+cur+used);
        }
        System.out.println(max);
    }
}
