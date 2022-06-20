package com.zhaohu.medium.sort;

import sun.font.TrueTypeFont;
import sun.reflect.generics.tree.Tree;

import java.lang.annotation.Target;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 5, 5, 3, 5, 5, 6};

//        int[] result = topKFrequent(nums, 2);
        findPeakElement1(new int[]{1, 2, 3});
        int[] result = searchRange(new int[]{2, 1, 1, 1, 3}, 1);
    }

    /**
     * 颜色分类
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        for (int i = 0; i <= right; i++) {

            if (nums[i] == 2) {
                change(nums, i, right);
                right--;
                i--;
            } else if (nums[i] == 0) {
                change(nums, i, left);
                left++;
            }
        }


    }

    static void change(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    /**
     * 找出出现频率前k高的元素
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for (int i = 0; i < nums.length; i++) {
            Integer value = map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int key : map.keySet()) {
            priorityQueue.add(new int[]{key, map.get(key)});
        }

        for (int i = 0; i < k; i++) {
            int[] res = priorityQueue.poll();
            result[i] = res[0];
        }

        return result;

    }

    public int[] topKFrequent1(int[] nums, int k) {
        //先统计每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        //最大堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int key : map.keySet())
            priorityQueue.add(new int[]{key, map.get(key)});

        //取堆中最大的k个元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = priorityQueue.poll()[0];
        return res;
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            int result = queue.poll();
            if (i == k - 1)
                return result;
        }

        return -1;
    }

    /**
     * 基于快排
     * k = nums.length - k;//注意这里的k已经变了
     * int lo = 0, hi = nums.length - 1;
     * while (lo <= hi) {
     * int i = lo;
     * //这里把数组以A[lo]的大小分为两部分，
     * //一部分是小于A[lo]的，一部分是大于A[lo]的
     * // [lo,i]<A[lo]，[i+1,j)>=A[lo]
     * for (int j = lo + 1; j <= hi; j++)
     * if (nums[j] < nums[lo])
     * swap(nums, j, ++i);
     * swap(nums, lo, i);
     * if (k == i)
     * return nums[i];
     * else if (k < i)
     * hi = i - 1;
     * else
     * lo = i + 1;
     * }
     * return -1;
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest1(int[] nums, int k) {
        k = nums.length - k;//注意这里的k已经变了
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int i = lo;
            //这里把数组以A[lo]的大小分为两部分，
            //一部分是小于A[lo]的，一部分是大于A[lo]的
            // [lo,i]<A[lo]，[i+1,j)>=A[lo]
            for (int j = lo + 1; j <= hi; j++)
                if (nums[j] < nums[lo])
                    swap(nums, j, ++i);
            swap(nums, lo, i);
            if (k == i)
                return nums[i];
            else if (k < i)
                hi = i - 1;
            else
                lo = i + 1;
        }
        return -1;
    }

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    /**
     * 寻找峰值
     * 1 1 2 1 3 4 3
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int mid = nums.length / 2;
        return findPeak(nums, 0, nums.length - 1, mid);
    }

    public int findPeak(int[] nums, int left, int right, int middle) {
        if (left == middle || right == middle)
            return nums[left] > nums[right] ? left : right;
        if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1])
            return middle;
        if (nums[middle] > nums[middle + 1])
            return findPeak(nums, left, middle + 1, left + (middle - left) / 2);
        else
            return findPeak(nums, middle, right, middle + (right - middle) / 2);

    }

    public static int findPeakElement1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (left == mid || right == mid)
                return nums[left] > nums[right] ? left : right;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            if (nums[mid] > nums[mid + 1])
                right = mid;
            else
                left = mid + 1;
        }

        return 0;
    }

    /**
     * 查找给定元素左右坐标
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] != target)
                left++;
            if (nums[right] != target)
                right--;
            if (left <= right && nums[left] == target && nums[right] == target)
                break;
        }

        if (left > right)
            return new int[]{-1, -1};

        return new int[]{left, right};
    }

    public int[] searchRange1(int[] nums, int target) {
        int left = -1;
        int right = -1;
        int index = findTarget(nums, 0, nums.length - 1, target);

        return nums;
    }

    public int findTarget(int[] nums, int left, int right, int target) {

        int mid = left + (right - left) / 2;
        int l = -1;
        int r = -1;
        if (nums[mid] == target) {
            return mid;
        }
        if (left == right)
            return -1;
        if (nums[mid] < target) {
            return findTarget(nums, left, mid, target);
        } else {
            return findTarget(nums, mid + 1, right, target);
        }
    }

    /**
     * 检索二维数组
     * 行升序
     * 列升序
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null)
            return false;

        int row = 0;
        int column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target)
                return true;
            else if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }

        return false;
    }


    /**
     * 合并区间
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2)
            return intervals;

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length; i++) {
            queue.add(intervals[i]);
        }
        List<int[]> list = new ArrayList<>();
        int[] current = queue.poll();
        while (!queue.isEmpty()) {
            int[] result = queue.poll();
            if (current[1] >= result[0]) {
                if (current[1] < result[1])
                    current[1] = result[1];

            } else {
                list.add(current);
                current = result;
            }
            if (queue.isEmpty()) {
                list.add(current);
            }
        }

        return list.toArray(new int[list.size()][2]);
    }

    /**
     * 搜索旋转数组
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        return findPoint(nums, 0, nums.length - 1, target);
    }

    /**
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    public int findPoint(int[] nums, int left, int right, int target) {
        int middle = left + (right - left) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        if(left==right)
            return -1;

        if(nums[middle]>=nums[left]){
            if(nums[middle]>target && nums[left]<=target){
                return findPoint(nums, left, middle, target);
            }else {
                return findPoint(nums, middle + 1, right, target);
            }
        }else {
            if(nums[middle]<target && nums[right]>=target){
                return findPoint(nums, middle + 1, right, target);
            }
            else {
                return findPoint(nums, left, middle, target);
            }
        }
    }
}

