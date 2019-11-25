package cn.wishhust.test;

import java.util.Scanner;
import java.util.Stack;

public class Test04 {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int [] [] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        scanner.nextLine();
        String str = scanner.nextLine();

        int count = 0;
        int index = 0;
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                continue;
            } else if(str.charAt(i) == ')') {
                int a = stack.pop();
                int b = stack.pop();
                count += (arr[a][0]*arr[a][1]*arr[b][0]);
                arr[b][1] = arr[a][1];
                stack.push(b);
            } else {
                stack.push(index++);
            }
        }

//        while (stack.size() > 1) {
//            int a = stack.pop();
//            int b = stack.pop();
//            count += (arr[a][0]*arr[a][1]*arr[b][0]);
//            arr[b][1] = arr[a][1];
//            stack.push(b);
//        }

        System.out.println(count);
    }
}
