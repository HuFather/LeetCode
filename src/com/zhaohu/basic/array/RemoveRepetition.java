package com.zhaohu.basic.array;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 移除按照升序排序的数组中重复的元素
 * 要求，原地
 */
public class RemoveRepetition {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
//        int s = removeDuplicates1(nums);
        List<List<Integer>> result = threeSum(new int[]{-2,0,1,1,2});
    }

    //双指针
    private static int removeDuplicates(int[] nums) {

        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[result]) {
                result++;
                nums[result] = nums[i];
            }
        }

        return result + 1;
    }

    private static int removeDuplicates1(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }

        return nums.length - count;
    }

    //双指针其他问题
    //给定一个包含 n 个整数的数组nums，判断nums中是否存在三个元素a ，b ，c ，使得a + b + c = 0 ？请找出所有和为 0 且不重复的三元组。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/1fGaJU
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    //-2,0,1,1,2，2
    //=0，a\b右移一位
    //>0, c左移一位
    //<0, b右移一位
    private static List<List<Integer>> threeSum(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        List<List<Integer>> result = new ArrayList<>();
        Set<String> duplicates = new HashSet<>();
        int index = 1, end = nums.length - 1;
        for (int start = 0; start < end - 1 && index < end; start++) {
            int temp = nums[start] + nums[index] + nums[end];
            if (temp == 0) {
                List<Integer> res = new ArrayList<>();

                res.add(nums[start]);
                res.add(nums[index]);
                res.add(nums[end]);
                String str = nums[start] + "" + nums[index] + "" + nums[end];
                if (!duplicates.contains(str)) {
                    duplicates.add(str);
                    result.add(res);
                }
                if(index!=end-1){
                    start--;
                    index=start+2;
                }
                index++;
                end=nums.length-1;
            } else if (temp > 0) {
                end--;
                start--;
            } else {
                if (index == end - 1) {
                    index = start + 2;
                } else {
                    index++;
                    start--;
                }
            }
        }

        return result;
    }

    // -4,0,1,3,4,6
    private static List<List<Integer>> threeSum1(int[] nums) {

        nums = Arrays.stream(nums).sorted().toArray();
        List<List<Integer>> result = new ArrayList<>();
        Set<String> duplicates = new HashSet<>();

        int index = 1;
        int end = nums.length - 1;
        for (int i = 0; i < end; i++) {

            if (index >= end) {
                i++;
                index = i + 2;
                end = nums.length-1;
                continue;
            }

            int sum = nums[i] + nums[index] + nums[end];
            if (sum == 0) {
                List<Integer> res = new ArrayList<>();

                res.add(nums[i]);
                res.add(nums[index]);
                res.add(nums[end]);
                String str = nums[i] + "" + nums[index] + "" + nums[end];
                if (!duplicates.contains(str)) {
                    duplicates.add(str);
                    result.add(res);
                }
                index++;
                end--;
            } else if (sum < 0) {
                index++;
            } else {
                end--;
            }
            i--;

        }

        return result;
    }

    //输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    //递归解决
    private static int[] reversePrint(ListNode head) {
        ArrayList<Integer> result = new ArrayList<>();
        if (head != null)
            getValue(head, result);

        int[] res = new int[result.size()];

        int i = 0;
        for (Integer r : result) {
            res[i++] = r;
        }

        return res;
    }

    private static void getValue(ListNode node, ArrayList<Integer> result) {
        if (node.next != null) {
            getValue(node.next, result);
        }
        result.add(node.val);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
