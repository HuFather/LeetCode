package com.zhaohu.basic.dynamicplanning;

import java.util.LinkedList;
import java.util.List;

class MinStack {

    List<Integer> data;
    List<Integer> mins;
    int index;

    public MinStack() {
        data = new LinkedList<>();
        mins = new LinkedList<>();
        index = -1;
    }

    public void push(int val) {
        int min = Math.min(index >= 0 ? mins.get(index) : Integer.MAX_VALUE, val);
        mins.add(min);
        data.add(val);
        index++;
    }

    public void pop() {
        data.remove(index);
        mins.remove(index);
        index--;
    }

    public int top() {
        return data.get(index);
    }

    public int getMin() {
        return mins.get(index);
    }
}

