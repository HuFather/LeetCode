package com.zhaohu.temporary;

public interface Default {
    public default void default12(){
        System.out.println("默认方法");
    }

    public default String test(){

        int age=100_45;
        return "";
    }
}
