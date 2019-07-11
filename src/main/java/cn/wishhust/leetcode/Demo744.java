package main.java.cn.wishhust.leetcode;

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

    public static void main(String[] args) {
        // ["a","b","c","d","e","f","g","h","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
        //"c"
        System.out.println(nextGreatestLetter(new char[]{'c','f','j'}, 'd'));
    }

}
