package com.zhaohu.basic.array;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * 移除按照升序排序的数组中重复的元素
 * 要求，原地
 */
public class RemoveRepetition {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        int s = removeDuplicates1(nums);
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
    //输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    //递归解决
    private static int[] reversePrint(ListNode head) {
        ArrayList<Integer> result=new ArrayList<>();
        if(head!=null)
            getValue(head,result);

        int[] res=new int[result.size()];

        int i=0;
        for (Integer r:result) {
            res[i++]=r;
        }

        return res;
    }

    private static void getValue(ListNode node,ArrayList<Integer> result){
        if(node.next!=null){
            getValue(node.next,result);
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
