package com.zhaohu.medium.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodecTest {
    Codec codec = new Codec();
    Codec codec1 = new Codec();

    @Test
    void serialize() {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);

        TreeNode three=new TreeNode(3);
        three.left=new TreeNode(4);
        three.right=new TreeNode(5);

        node.right=three;

        TreeNode node1=codec.deserialize(codec.serialize(node));


        System.out.println();
    }

    @Test
    void deserialize() {
        TreeNode node=new TreeNode(1);
//        node.left=new TreeNode(2);
//
//        TreeNode three=new TreeNode(3);
//        three.left=new TreeNode(4);
//        three.right=new TreeNode(5);
//
//        node.right=three;

        TreeNode node1=codec.deserialize(codec.serialize(node));


        System.out.println();
    }
}