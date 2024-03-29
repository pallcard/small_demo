package cn.wishhust.leetcode;

/**
 * 744. 寻找比目标字母大的最小字母
 *
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 *
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 *
 * 示例:
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 * 注:
 *
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 *
 */

public class Demo744 {

    public static char nextGreatestLetter(char[] letters, char target) {

        int left = 0 ;
        int right = letters.length-1;
        int mid = (right+left)/2;

        if (target >= letters[letters.length-1]) {
            return letters[0];
        }

        while (left < right) {

            if(letters[mid] > target) {
                right = mid-1;
            } else if(letters[mid] < target) {
                left = mid+1;
            } else {
                while (letters[mid+1] == target) {
                    mid++;
                }
                return letters[mid%letters.length];
            }

            mid = (right+left)/2;
        }
        if (left == right && letters[mid] <= target ) {
            return letters[mid+1];
        }
        return letters[mid];
    }

    public static char nextGreatestLetter2(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;


        // = 用得好
        while (left <= right) {
            int mid = (left+right)/2;
            if (letters[mid] < target) {
                left = mid+1;
            } else  {
                right = mid -1;
            }
        }


        return left < letters.length ? letters[left]:letters[0];

    }


    public static void main(String[] args) {
        // ["a","b","c","d","e","f","g","h","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
        //"c"
        System.out.println(nextGreatestLetter2(new char[]{'c','f','j'}, 'd'));
    }

}
