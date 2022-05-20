package com.zhaohu.basic.design;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @creator : zhaohu
 * @date : 5/20/2022
 * @description :
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution=new Solution(new int[]{1,2,3,4});
        int[] result= solution.reset();
        result=solution.shuffle();
        result=solution.reset();
    }

    private int[] originNums;


    public Solution(int[] nums) {
        originNums=nums.clone();

    }

    public int[] reset() {
        return originNums;
    }

    public int[] shuffle() {
        int total=originNums.length;
        int[] result=new int[total];
        LinkedList<Integer> array=new LinkedList<Integer>();
        for (int i = 0; i < originNums.length; i++) {
            array.add(originNums[i]);
        }
        while (total>0){
            int index= new Random().nextInt(total);
            result[total-1]= (int) array.remove(index);
            total--;
        }

        return result;
    }

}
