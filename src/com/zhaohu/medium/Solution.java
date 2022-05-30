package com.zhaohu.medium;

import com.sun.deploy.util.JarUtil;
import com.sun.deploy.util.StringUtils;

import javax.swing.text.StyledEditorKit;
import java.util.*;

/**
 * @creator : zhaohu
 * @date : 5/26/2022
 * @description :
 */
public class Solution {

    public static void main(String[] args) {
//        lengthOfLongestSubstring("abcabcbb");

//        longestPalindrome("babad");

        increasingTriplet(new int[]{1,2,3,4,5});
    }

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        List<Integer> columns = new ArrayList<>();
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    columns.add(j);
                    rows.add(i);
                }
            }
        }

        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < column; j++) {
                matrix[rows.get(i)][j] = 0;
            }
        }
        for (int i = 0; i < columns.size(); i++) {
            for (int j = 0; j < row; j++) {
                matrix[j][columns.get(i)] = 0;
            }
        }

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> curResult = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String current = String.valueOf(chars);
            if (curResult.containsKey(current)) {
                curResult.get(current).add(str);
            } else {
                ArrayList<String> currentList = new ArrayList<>();
                currentList.add(str);
                curResult.put(current, currentList);
            }
        }
        for (String key : curResult.keySet()) {
            result.add(curResult.get(key));
        }

        return result;
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0)
            return 0;

        int maxNum = 1;
        int left = 0;
        int right = 1;
        char[] chars = s.toCharArray();
        while (right < s.length()) {
            if (s.substring(left, right).contains(String.valueOf(chars[right]))) {
                left++;
            } else {
                right++;
                maxNum = Math.max(maxNum, right - left);
            }
        }

        return maxNum;
    }

    public static int lengthOfLongestSubStr(String s) {

        if (s.length() == 0)
            return 0;

        //记录出现的字符及索引
        //如果出现了，更新left值
        Map<Character, Integer> map = new HashMap<>();
        int total = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);

            total = Math.max(total, i - j + 1);
        }

        return total;
    }

    /**
     * 中心扩散
     * 1. 遍历字符串
     * 2. 规避掉相等的
     * 3. 设置下次比较的位置
     * 4. 判断回文、计数
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int maxLength = 0;
        int start = 0;

        if (s.length() < 2)
            return s;
        //遍历，每次以当前元素为中心扩散
        for (int i = 0; i < s.length(); ) {
            //剩余元素个数小于最大的一半，则停止
            if (s.length() - i < maxLength / 2) {
                break;
            }

            int left = i;
            int right = i;
            //规避掉相等的
            while (right < s.length() - 1 && s.charAt(right) == s.charAt(right + 1))
                right++;

            i = right + 1;//从下一个开始做对比
            while (right < s.length() - 1 && left > 0 && s.charAt(left - 1) == s.charAt(right + 1)) {
                right++;
                left--;
            }
            //交换
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
        }

        return s.substring(start, start + maxLength);
    }


    /**
     * 递增的三元子序列
     * 1. 记录最小值、第二小值
     * 2. 如果有最小，更新最小，有第二小，更新第二小
     * 3. 如果有比第二小大的，成立
     * @param nums
     * @return
     */
    public static boolean increasingTriplet(int[] nums) {
        int mix=Integer.MAX_VALUE;
        int subMix=Integer.MAX_VALUE;
        for (int num:nums){
            if(mix>=num)
                mix=num;
            else if(subMix>=num)
                subMix=num;
            else
                return true;
        }

        return false;
    }
//
//    //3个数字，small记录最小的数字
//    int small = Integer.MAX_VALUE;
//    //mid记录中间的数字
//    int mid = Integer.MAX_VALUE;
//        for (int num : nums) {
//        if (num <= small) {
//            //记录遍历过的最小值
//            small = num;
//        } else if (num <= mid) {
//            //记录比small大的最小值，也就是mid的值
//            mid = num;
//        } else {
//            //mid如果赋值了，那么之前肯定有个比
//            //mid小的值，这里又有个比mid大的值，
//            //所以他们三个可以构成递增的三元子序列
//            return true;
//        }
//    }
//        return false;
//

}
