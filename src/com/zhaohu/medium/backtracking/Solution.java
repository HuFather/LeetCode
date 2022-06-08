package com.zhaohu.medium.backtracking;

import java.util.*;

/**
 * @creator : zhaohu
 * @date : 6/8/2022
 * @description :
 */
public class Solution {

    public static void main(String[] args) {
//        permutation(new int[]{1,2,3});
        List<String> result = letterCombinations("7");
    }

    private static Map<Character, List<Character>> map = new HashMap<>();

    static {
        char index = 50;
        int i = 96;
        for (; index < 55; index++) {
            List<Character> list = new ArrayList<>();
            list.add((char) ++i);
            list.add((char) ++i);
            list.add((char) ++i);
            map.put(index, list);
        }

        List<Character> char1 = new ArrayList<>();
        char1.add('q');
        char1.add('p');
        char1.add('r');
        char1.add('s');
        map.put('7', char1);

        List<Character> char2 = new ArrayList<>();
        char2.add('t');
        char2.add('u');
        char2.add('v');
        map.put('8', char2);

        List<Character> char3 = new ArrayList<>();
        char3.add('w');
        char3.add('x');
        char3.add('y');
        char3.add('z');
        map.put('9', char3);
    }

    /**
     * 字母组合
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.isEmpty() || digits.length() < 1)
            return result;
        track(digits, new StringBuilder(), result, 0);
        return result;
    }

    public static void track(String digits, StringBuilder res, List<String> result, int level) {
        if (digits.length() == res.length()) {
            result.add(new StringBuilder(res).toString());
            return;
        }
        char[] chars1 = digits.toCharArray();
        for (int j = 0; j < chars1.length; j++) {
            List chars = map.get(chars1[j]);

            for (int i = 0; i < chars.size(); i++) {
                Character cc = (Character) chars.get(i);
                if (j < level)
                    break;
                res.append(cc);

//                String digitsSub=digits.substring(i+1);
                track(digits, res, result, j + 1);
                res.deleteCharAt(res.length() - 1);

            }
        }

    }


    /**
     * 数字全排列
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        trace(nums, new ArrayList<>(), result);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
        return result;
    }

    public static void trace(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (nums.length == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            trace(nums, list, result);
            list.remove(list.size() - 1);
        }
    }


}
