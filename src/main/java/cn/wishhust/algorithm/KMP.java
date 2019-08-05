package cn.wishhust.algorithm;

public class KMP {


    public static int [] GetNext(String p) {
        int pLen = p.length();
        int [] next = new int [p.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pLen-1) {

            if (k == -1 || p.charAt(j) == p.charAt(k)) {
                k++;
                j++;
                next[j] = k;
//                //较之前next数组求法，改动在下面4行
//                if (p.charAt(j) != p.charAt(k))
//                    next[j] = k;   //之前只有这一行
//                else
//                    //因为不能出现p[j] = p[ next[j]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
//                    next[j] = next[k];

            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static int KMPSearch(String s, String p) {
        int i = 0;
        int j = 0;
        int sLen = s.length();
        int pLen = p.length();

        int [] next = GetNext(p);

        while (i < sLen && j < pLen) {

            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else  {
                j = next[j];
            }
        }

        if (j == pLen) {
            return i-j;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(KMPSearch("abcabcabcabdffff","abcabcabc"));
    }
}
