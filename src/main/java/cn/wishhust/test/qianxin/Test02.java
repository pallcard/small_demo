package cn.wishhust.test.qianxin;

import java.util.Scanner;

public class Test02 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static String find_longest_num_str(String input) {
        int index = 0;
        int max = 0;
        int curIndex = 0;
        int curMax = 0;

        for (int i = 0; i < input.length(); i++) {
            int t = input.charAt(i)-'0';
            if (t>=0 && t<=9) {
                curMax++;
                if (i-1>0 && input.charAt(i-1)-'0'<0 || input.charAt(i-1)-'0'>9) {
                    curIndex = i;
                }
            } else {
                if(max < curMax) {
                    max = curMax;
                    index = curIndex;
                }
                curIndex = -1;
                curMax = 0;
            }

        }
        return input.substring(index,index+max);
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = find_longest_num_str(_input);
        System.out.println(String.format("%d/%s", res.length(), res));
    }
}
