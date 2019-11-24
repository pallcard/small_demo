package cn.wishhust.leetcode;

/**
 *
 * 204. 计数质数
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */

public class Demo204 {
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrimes(int n) {
        for (int i = 2; i < (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static int countPrimes2(int n) {
        if(n==0 || n==1 || n==2) return 0;
        int count = 0;
        boolean [] p = new boolean [n];

        for(int i = 2; i < n;i++)//遍历从2到n的数
        {
            if(p[i] == false)//若i为素数
            {
                count++;//统计个数
                for(int j = i+i; j < n;j+=i)//筛掉i的倍数
                {
                    p[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
