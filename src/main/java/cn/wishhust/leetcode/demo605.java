package cn.wishhust.leetcode;
public class demo605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0) {
            return true;
        }

        if(flowerbed.length == 1 && flowerbed[0] == 0 && n == 1) {
            return true;
        } else if(flowerbed.length == 1){
            return false;
        }

        // 数组长度为2以上

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
           if(--n == 0) {
               return true;
            } else {
               flowerbed[0] = 1;
           }
        }

        for (int i = 1; i < flowerbed.length-1; i++) {
            if (flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                if(--n == 0) {
                    return true;
                } else {
                    flowerbed[i]=1;
                }
            }
        }

        if (flowerbed[flowerbed.length-2] == 0 && flowerbed[flowerbed.length-1] == 0) {
            if(--n == 0) {
                return true;
            }
        }

        return false;
    }

}
