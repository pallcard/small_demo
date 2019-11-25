package cn.wishhust.test.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/


    private static int[] findSplitPoint(List<Integer> lengthList, int m) {
        int totalNum = 0;
        for (int i = 0; i < lengthList.size(); i++) {
            totalNum += lengthList.get(i);
        }
        //平均值
        double average = (double) totalNum / (double) m;
        System.out.println("average=" + average);
        int groupNum = 0;
        int[] pointArr = new int[m - 1];
        int pointArrIndex = 0;
        double minDiffSum = -1;
        int i = 0;
        for (; i < lengthList.size(); i++) {
            int num = lengthList.get(i);
            //按顺序累加
            groupNum += num;
            double curDiffSum = Math.abs(groupNum - average);

            int surplusGroupNum = m - 1 - pointArrIndex;
            int surplusDataNum = lengthList.size() - i;
            int differNum = surplusDataNum - surplusGroupNum;

            if (differNum > 0) {
                //当前累加 与平均值的距离 < 上次累加与平均值的距离
                if (curDiffSum < minDiffSum || minDiffSum == -1) {
                    minDiffSum = curDiffSum;
                } else {
                    //保存切分点
                    pointArr[pointArrIndex] = i;
                    if (pointArrIndex == m - 2) {
                        break;
                    }
                    pointArrIndex++;
                    groupNum = num;
                    minDiffSum = Math.abs(num - average);
                }
            } else {
                //简单解决大数分布到头尾，不够分组的情况。把末尾的每个值单独分为一组。
                pointArr[pointArrIndex++] = i;
                int point = i + 1;
                for (int j = 0; j < surplusGroupNum - 1; j++) {
                    pointArr[pointArrIndex++] = point++;
                }
                break;
            }

        }
        return pointArr;
    }

    static void buildResultList(List<List<Integer>> resultList, List<Integer> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(dataList.get(i));
            resultList.add(list);
        }
    }

    static void buildResultList(List<List<Integer>> resultList, List<Integer> dataList, int[] resultArr) {
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
            int[] pointArr = findSplitPoint(lengthList, m);
            buildResultList(resultList, lengthList, pointArr);
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
    /******************************结束写代码******************************/


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
}
