package com.zhaohu.offer.day1;

import java.util.HashSet;

/**
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class BinaryPlus {
    public static void main(String[] args) {
        String result=addBinary("11","10");
    }
    public static String addBinary(String a,String b){
        String  c=b;
        if (a.length()<b.length()){
            b=a;
            a=c;
        }

        char[] ac=a.toCharArray();
        char[] bc=b.toCharArray();
        int carry=0;
        int gap=ac.length-bc.length;
        for (int i = a.length()-1; i>=gap; i--) {
            int current=ac[i]+bc[i-gap]+carry*49;
            if (current==49*3){
                ac[i]='1';
                carry=1;
            }else if(current==49*2){
                ac[i]='0';
                carry=1;
            }else if (current==49){
                ac[i]='1';
                carry=0;
            }else {
                ac[i]='0';
                carry=0;
            }
        }
        if(carry==1){
            for (int i=a.length()-b.length()-1; i >=0 ;i--) {
                int current=ac[i]+carry*49;
                if(current==49*2){
                    ac[i]='0';
                    carry=1;
                }else {
                    carry=0;
                    break;
                }
            }
        }

        if(carry==1)
            return carry+String.copyValueOf(ac);
        return String.copyValueOf(ac);

    }

}
