package cn.wishhust.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 12. 整数转罗马数组
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4不写做IIII，而是IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
 *
 * 这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 * 使用一个map存放罗马字符与数值的映射关系。将6种特殊情况也存放在map中。
 */
public class Demo012 {
    public static String intToRoman(int num) {
        Map<String, Integer> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();

        map.put("M",1000);
        map.put("CM",900);
        map.put("D",500);
        map.put("CD",400);
        map.put("C",100);
        map.put("XC",90);
        map.put("L",50);
        map.put("XL",40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I",1);

        for(Map.Entry<String, Integer> e : map.entrySet()) {
            int count = num / e.getValue();
            num = num % e.getValue();
            while (count-- > 0) {
                sb.append(e.getKey());

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println( intToRoman(1001));
    }
}
