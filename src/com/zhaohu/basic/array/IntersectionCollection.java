package com.zhaohu.basic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionCollection {
    protected  static String xxx="0-";
    public static int[] intersection(int[] nums1,int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result=new ArrayList<>();
        int l1=0;
        int l2=0;
        while (l1<nums1.length && l2<nums2.length){
            if(nums1[l1]==nums2[l2]){
                result.add(nums1[l1]);
                l1++;
                l2++;
            }else if(nums1[l1]<nums2[l2]){
                l1++;
            }
            else {
                l2++;
            }
        }
        int[] last=new int[result.size()];
        for (int i = 0; i < last.length; i++) {
            last[i]=result.get(i);
        }
        return last;
    }
}
