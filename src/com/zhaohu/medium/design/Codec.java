package com.zhaohu.medium.design;

public class Codec {
    private static final String SEPARATE = ",";
    private static final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    private void serialize(TreeNode root, StringBuilder stringBuilder) {
        if (root != null) {
            stringBuilder.append(root.val).append(SEPARATE);
            serialize(root.left, stringBuilder);
            serialize(root.right, stringBuilder);
        } else {
            stringBuilder.append(NULL).append(SEPARATE);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(SEPARATE);
        TreeNode dummy = deserialize(values, 0);
        return dummy;
    }

    int index_1 = 0;

    private TreeNode deserialize(String[] data, int index) {
        if (index_1 >= data.length) {
            return null;
        }
        if (data[index_1].equals(NULL))
            return null;

        TreeNode root = new TreeNode(Integer.valueOf(data[index_1]));
        root.left = deserialize(data, ++index_1);
        root.right = deserialize(data, ++index_1);

        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
