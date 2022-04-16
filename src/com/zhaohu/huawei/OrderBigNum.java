package com.zhaohu.huawei;

import java.util.*;

/**
 *给定一组非负数，将这些数重新排列，组成一个最大值
 */
public class OrderBigNum {

    public static void main(String[] args) {
//        String  result= OrderBigNum.getBigNum(new int[]{9,908,933});
        int[] result=getMinAbs(new int[]{-1,-3,7,5,11,15});
    }

    /**
     * 找出最高位最大的数字，有相同的，则取最短的；位数相同，取最大的 9 908 933
     *
     * @param nums
     * @return
     */
    public static String  getBigNum(int[] nums){
        PriorityQueue<String> heap=new PriorityQueue<>((x,y)->(y+x).compareTo(x+y));
        for (int i = 0; i < nums.length; i++) {
            heap.offer(String.valueOf(nums[i]));
        }
        String result="";

        while (!heap.isEmpty()){
            result+=heap.poll();
        }
        if(result.charAt(0)=='0')
            return "0";
        return result;
    }


    /**
     * 找出绝对值最小的两个数
     * @param nums
     * @return
     */
    public static int[] getMinAbs(int[] nums){
        nums= Arrays.stream(nums).sorted().toArray();
        if (nums.length<2){
            return new int[]{0,0,0};
        }
        Integer min=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>=0){

                if(i>0){
                    for (int j = i-1; j >=0 ; j--) {
                        int temp=nums[j]+nums[i];
                        if(temp<min){
                            min=temp;
                            break;
                        }
                        else {
                            return new int[]{j,i,min};
                        }

                    }
                    return new int[]{nums[i-1],nums[i],nums[i]+nums[i-1]};
                }else {
                    return new int[]{nums[0],nums[1],nums[0]+nums[1]};
                }
            }
        }
        return new int[]{nums[nums.length-2],nums[nums.length-1],nums[nums.length-2]+nums[nums.length-1]};
    }
}
