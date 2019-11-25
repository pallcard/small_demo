package cn.wishhust.algorithm;

/**
 * 剪绳子
 *
 * 把一根绳子剪成多段，并使得所得到每段绳子的长度之积最大。
 *
 * 2 = 1 + 1  =》 1*1=1
 * 10 = 3+3+4 =》 3*3*4=36
 * 11 = 3+3+3+2 =》 3*3*3*2=54
 *
 * 使得所得到的绳子中3的数量最多，1的数量最少（没有）
 */
public class Demo014 {

    // 贪婪算法
    public static int maxLength(int n) {
        if (n < 2) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else {
            if (n%3==1){
                return (int) Math.pow(3, n/3-1)*4;
            } else if(n%3==0) {
                return (int) Math.pow(3, n/3);
            } else {
                return (int) Math.pow(3, n/3)*2;
            }
        }
    }

    // 动态规划
    // 定义 f(n) : 最大乘积
    // f(n) = max{f(i)*f(n-i)}
    public static int dp(int n) {
        if (n < 2) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else {
            int [] dp = new int [n+1];
            // 分割绳子长度1，2，3，具体动态规划从4开始计算
            // dp[i]数组,绳子长度为i时，乘积最大值
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;
            int max = 0;
            // 存放中间值
            int temp = 0;
            for (int i = 4; i <= n; i++) {
                max = 0;
                // i/2 对于绳子i的切分，j*(i-j) 与 (i-j)*j结果一样
                for (int j = 1; j <= i / 2; j++) {
                    temp = dp[j] * dp[i-j];
                    if (temp > max) {
                        max = temp;
                    }
                }
                dp[i] = max;
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(maxLength(11));
        System.out.println(dp(11));
    }
}
