package com.zhaohu;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println(test());
    }
    public static int test(){
        Integer x;
        try{
            x=1;
            //int y=1/0;
            return x;
        }
        finally {
            x=3;
            return x;
        }


    }

    public class  ttt{
        int x;
    }


}
