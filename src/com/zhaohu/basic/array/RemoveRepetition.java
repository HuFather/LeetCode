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
        List<List<Integer>> result = threeSum(new int[]{3,0,-2,-1,1,2});
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
    //-2,-1,0,1,2,3
    //=0，a\b右移一位
    //>0, c左移一位
    //<0, b右移一位
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n=nums.length;
        for (int start = 0; start < n; start++) {
            if(start>0 && nums[start]==nums[start-1]){
                continue;
            }
            int end=n-1;
            int target=-nums[start];
            for (int index = start+1; index < n; index++) {
                if(index>start+1 && nums[index]==nums[index-1]){
                    continue;
                }
                while (index<end && nums[index]+nums[end]>target){
                    --end;
                }
                if(index==end){
                    break;
                }
                if(nums[index]+nums[end]==target){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[start]);
                    list.add(nums[index]);
                    list.add(nums[end]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    private static ListNode sortList(ListNode head){

        return null;
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
