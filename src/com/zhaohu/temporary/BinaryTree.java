package com.zhaohu.temporary;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        ListNode left=new ListNode(2);
        ListNode right=new ListNode(3);
        left.left=new ListNode(4);
        node.left=left;
        node.right=right;

        List<Integer> result= rightNum(node);

    }
    public static List<Integer> rightNum(ListNode node){
        List<Integer> result=new ArrayList<>();
        if(node==null){
            return result;
        }

        LinkedList<ListNode> nodes=new LinkedList<>();
        nodes.add(node);
        while (!nodes.isEmpty()){
            int length=nodes.size();
            for (int i = 0; i < length; i++) {

                ListNode currentNode=nodes.poll();
                if(i==length-1){
                    result.add(currentNode.val);
                }
                if(currentNode.left!=null){
                    nodes.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    nodes.add(currentNode.right);
                }
            }
        }

        return result;
    }
}


class ListNode {
    int val;
    public ListNode left;
    public ListNode right;
    ListNode(int x) {
        val = x;
    }
}