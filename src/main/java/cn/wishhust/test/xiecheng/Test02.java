package cn.wishhust.test.xiecheng;

import java.util.*;

public class Test02 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) != ')') {
                stack.push(expr.charAt(i));
            } else {
                char c;
                while ((c= stack.pop()) != '(' && !stack.isEmpty()) {
                    queue.add(c);
                }
                if (c != '(') {
                    return "";
                }
                while (!queue.isEmpty()) {
                    stack.push(queue.poll());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "";
            }
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
