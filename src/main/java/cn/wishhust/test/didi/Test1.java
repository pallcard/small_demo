package cn.wishhust.test.didi;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        final String[] s = str.split(" ");
        int [] nums = new int[n];
        char [] symbol = new char[n-1];
        int  index = 0;
        int i=0, j=0;
        while (index < s.length) {
            nums[i++] = Integer.parseInt(s[index++]);
            if (index < s.length-1) {
                symbol[j++] = s[index++].charAt(0);
            }
        }

        boolean flag = true;
        for (int l = 0; l < n; l++) {
            for (int k = 0; k < n-1; k++) {
                if (nums[k] > nums[k+1]) {
                    if (symbol[k] == '*') {
                        int temp = nums[k];
                        nums[k] = nums[k+1];
                        nums[k+1] = temp;
                        flag = false;
                    }
                    if (symbol[k] == '+' && (k == 0 || symbol[k-1] == '+') && (k+1==n-1 || symbol[k+1] == '+' || symbol[k+1] == '-')) {
                        int temp = nums[k];
                        nums[k] = nums[k+1];
                        nums[k+1] = temp;
                        flag = false;
                    }
                }
            }
            if (flag) {
                break;
            }
            flag = true;
        }
        System.out.println(mer(nums, symbol));

    }

    public static String mer(int [] nums, char [] symbol) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < symbol.length) {
            sb.append(nums[index]);
            sb.append(symbol[index]);
            index++;
        }
        sb.append(nums[index]);
        return sb.toString();
    }
}
