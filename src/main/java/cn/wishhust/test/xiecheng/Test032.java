package cn.wishhust.test.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Test032 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }

    static int schedule(int m,int[] array) {
        int max2 = 0;
        for (int i = 0; i < array.length; i++) {
            max2 = Math.max(max2, array[i]);
        }
        if (m > array.length) {
            return max2;
        }
        List<Integer> lengthList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            lengthList.add(array[i]);
        }
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (lengthList.size() < m) {
            buildResultList(resultList, lengthList);
        } else {
            int endIndex = lengthList.size() - (m - 2);
            int[] tempArr = new int[m - 1];
            List<int[]> combList = new ArrayList<int[]>();
            int num = -1;
            //所有切分点的组合存入combList
            Combine(lengthList, m - 1, tempArr, 0, 0, combList);
            int[] resultArr = null;
            for (int[] combArr : combList) {
                int[] sumArr = getSum(combArr, lengthList);
                int diffSum = computeDifferent(sumArr);
                if (diffSum < num || num == -1) {
                    num = diffSum;
                    resultArr = combArr;
                }
            }


            buildResultList(resultList, lengthList, resultArr);
        }
        int max = 0;
        for (int i = 0; i < resultList.size(); i++) {
            int sum = 0;
            for (int j = 0; j < resultList.get(i).size(); j++) {
                sum += resultList.get(i).get(j);
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    //如果分组数m大于等于集合的长度。
    static void buildResultList(List<List<Integer>> resultList,
                                List<Integer> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(dataList.get(i));
            resultList.add(list);
        }
    }

    // 根据最优切分点构建结果集
    static void buildResultList(List<List<Integer>> resultList,
                                List<Integer> dataList, int[] resultArr) {
        if (resultList == null || dataList == null || resultArr == null) {
            return;
        }
        int j = 0;
        int maxJ = 0;
        for (int i = 0; i <= resultArr.length; i++) {
            if (i == resultArr.length) {
                maxJ = dataList.size();
            } else {
                maxJ = resultArr[i];
            }
            List<Integer> list = new ArrayList<Integer>();
            for (; j < maxJ; j++) {
                list.add(dataList.get(j));
            }
            resultList.add(list);
        }
    }
    //每种组合不同段的和。比如0--2  2--5   5--list的结尾
    static int[] getSum(int[] combArr, List<Integer> dataList) {
        if (combArr == null || dataList == null) {
            return null;
        }
        int[] sumArr = new int[combArr.length + 1];
        int j = 0;
        int sum = 0;
        int maxJ = 0;
        for (int i = 0; i <= combArr.length; i++) {

            if (i == combArr.length) {
                maxJ = dataList.size();
            } else {
                maxJ = combArr[i];
            }
            for (; j < maxJ; j++) {
                sum += dataList.get(j);
            }
            sumArr[i] = sum;
            System.out.println("sum=" + sum);
            sum = 0;
        }
        return sumArr;
    }

    // 数组中值两两比较，差的绝对值的和累加
    static int computeDifferent(int[] sumArr) {
        int diffSum = 0;
        for (int i = 0; i < sumArr.length; i++) {
            for (int j = i + 1; j < sumArr.length; j++) {
                diffSum += Math.abs(sumArr[i] - sumArr[j]);
            }
        }
        System.out.println("diffSum=" + diffSum);
        return diffSum;
    }

    // 所有切分点组合
    private static void Combine(List<Integer> lengthList, int num,
                                int[] tempArr, int tempArrIndex, int low, List<int[]> combList) {
        if (lengthList == null || lengthList.size() < num) {
            return;
        }
        if (num == 0) {
            if (tempArr[tempArr.length - 1] != lengthList.size()) {
                combList.add(tempArr);
            }
        } else {
            for (int i = low; i < lengthList.size(); i++) {
                tempArr[tempArrIndex] = i + 1;
                Combine(lengthList, num - 1, tempArr, ++tempArrIndex, i + 1,
                        combList);
                int[] newTempArr = new int[tempArr.length];
                System.arraycopy(tempArr, 0, newTempArr, 0, tempArr.length - 1);
                tempArr = newTempArr;
                tempArrIndex--;
            }
        }
    }
}
