package com.zhaohu.medium.treegraph;

import java.util.*;

/**
 * @creator : zhaohu
 * @date : 6/2/2022
 * @description :
 */
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.test();
    }

    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;

        kthSmallest(root, 2);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> nodes = new LinkedList<>();

        while (root != null || !nodes.isEmpty()) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }
            if (!nodes.isEmpty()) {
                TreeNode node = nodes.pop();
                result.add(node.val);
                root = node.right;
            }
        }

        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        middle(root, result);
        return result;
    }

    private void middle(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        middle(root.left, list);
        list.add(root.val);
        middle(root.right, list);
    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight)
                    current.add(node.val);
                else
                    current.add(0, node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            leftToRight = !leftToRight;
            result.add(current);
        }

        return result;
    }

    public void travel(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null)
            return;
        if (res.size() <= level)
            res.add(new ArrayList<>());

        if (level % 2 == 0)
            res.get(level).add(node.val);
        else
            res.get(level).add(0, node.val);

        travel(node.left, res, level + 1);
        travel(node.right, res, level + 1);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
            inorderList.add(inorder[i]);
        }

        return find(preorderList, inorderList);
    }

    public TreeNode find(List<Integer> preorder, List<Integer> inorder) {
        if (inorder.size() == 0)
            return null;

        int rootValue = preorder.remove(0);
        TreeNode root = new TreeNode(rootValue);
        int index = inorder.indexOf(rootValue);
        root.left = find(preorder, inorder.subList(0, index));
        root.right = find(preorder, inorder.subList(index + 1, inorder.size()));

        return root;
    }

    /**
     * 连接下一个node
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        root.next = null;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                current.next = queue.peek();
                if (i == size - 1)
                    current.next = null;

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        connect1(root);
        return root;
    }

    public Node connect1(Node root) {

        if (root == null)
            return null;

        Node cur = root;
        while (cur != null) {
            Node dummy = new Node();
            Node pre = dummy;

            while (cur != null && cur.left != null) {
                pre.next = cur.left;
                pre = pre.next;

                pre.next = cur.right;
                pre = pre.next;

                cur = cur.next;
            }
            cur = dummy.next;
        }

        return root;

    }


    /**
     * 查找树种第k小的数
     *
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        addToQueue(root, queue);

        int result = 0;
        for (int i = 0; i < k; i++) {
            result = queue.poll();
        }

        return result;
    }

    public static void addToQueue(TreeNode root, PriorityQueue<Integer> queue) {
        if (root == null)
            return;
        queue.add(root.val);
        addToQueue(root.left, queue);
        addToQueue(root.right, queue);
    }


    /**
     * 岛屿数量
     *
     * @param grid
     * @return ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     */
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int num = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    num++;

                    sentZero(grid,i,j);
                }
            }
        }

        return num;
    }

    public void sentZero(char[][] grid, int row, int column) {

        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == '0') {
            return;
        }

        grid[row][column] = '0';
        sentZero(grid, row - 1, column);
        sentZero(grid, row + 1, column);
        sentZero(grid, row, column + 1);
        sentZero(grid, row, column - 1);

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //     Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
