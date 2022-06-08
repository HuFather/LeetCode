package com.zhaohu.medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @creator : zhaohu
 * @date : 6/8/2022
 * @description :
 */
public class Solution {

    public static void main(String[] args) {
        permutation(new int[]{1,2,3});
    }

    /**
     * 字母组合
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        return null;
    }

    /**
     * 数字全排列
     * @param nums
     * @return
     */
    public static List<List<Integer>> permutation(int[] nums){
        List<List<Integer>> result=new LinkedList<>();
        trace(nums,new ArrayList<>(),result);

        for (List<Integer> list:result){
            System.out.println(list);
        }
        return result;
    }
    
    public static void trace(int[] nums,List<Integer> list,List<List<Integer>> result){
        if(nums.length==list.size()){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            trace(nums,list,result);
            list.remove(list.size()-1);
        }
    }


}
