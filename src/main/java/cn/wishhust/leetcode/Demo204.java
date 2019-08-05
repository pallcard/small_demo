package cn.wishhust.leetcode;
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
