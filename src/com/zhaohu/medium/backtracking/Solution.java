package com.zhaohu.medium.backtracking;

import java.util.*;

/**
 * @creator : zhaohu
 * @date : 6/8/2022
 * @description :
 */
public class Solution {

    public static void main(String[] args) {
//        permutation(new int[]{1,2,3});
//        List<List<Integer>> result = permute(new int[]{1, 2, 3});
//        System.out.println(result);
//        List<List<Integer>> result = subsets1(new int[]{1, 2, 3});
        char[][] test = new char[][]{{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        boolean result = exist(test, "ba");
    }

    private static Map<Character, List<Character>> map = new HashMap<>();

    static {
        char index = 50;
        int i = 96;
        for (; index < 55; index++) {
            List<Character> list = new ArrayList<>();
            list.add((char) ++i);
            list.add((char) ++i);
            list.add((char) ++i);
            map.put(index, list);
        }

        List<Character> char1 = new ArrayList<>();
        char1.add('q');
        char1.add('p');
        char1.add('r');
        char1.add('s');
        map.put('7', char1);

        List<Character> char2 = new ArrayList<>();
        char2.add('t');
        char2.add('u');
        char2.add('v');
        map.put('8', char2);

        List<Character> char3 = new ArrayList<>();
        char3.add('w');
        char3.add('x');
        char3.add('y');
        char3.add('z');
        map.put('9', char3);
    }

    /**
     * 字母组合
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.isEmpty() || digits.length() < 1)
            return result;
        track(digits, new StringBuilder(), result, 0);
        return result;
    }

    public static void track(String digits, StringBuilder res, List<String> result, int level) {
        if (digits.length() == res.length()) {
            result.add(new StringBuilder(res).toString());
            return;
        }
        char[] chars1 = digits.toCharArray();
        for (int j = 0; j < chars1.length; j++) {
            List chars = map.get(chars1[j]);

            for (int i = 0; i < chars.size(); i++) {
                Character cc = (Character) chars.get(i);
                if (j < level)
                    break;
                res.append(cc);

//                String digitsSub=digits.substring(i+1);
                track(digits, res, result, j + 1);
                res.deleteCharAt(res.length() - 1);

            }
        }

    }


    /**
     * 字母组合
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations1(String digits) {
        LinkedList<String> result = new LinkedList<>();

        if (digits == null || digits.isEmpty())
            return result;

        result.add("");
        char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

        while (result.peek().length() != digits.length()) {
            String remove = result.poll();
            char[] chars = tab[digits.charAt(remove.length()) - '2'];
            for (int i = 0; i < chars.length; i++) {
                result.add(remove + chars[i]);
            }
        }

        return result;
    }

    public List<String> letterCombinations2(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits == null || digits.isEmpty())
            return result;
        char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        dfs(result, 0, "", tab, digits);
        return result;
    }

    public void dfs(List<String> result, int index, String path, char[][] tab, String digits) {
        if (path.length() == digits.length()) {
            result.add(path);
            return;
        }

        char[] chars = tab[digits.charAt(index) - '2'];
        for (int i = 0; i < chars.length; i++) {
            dfs(result, index + 1, path + chars[i], tab, digits);
        }
    }

    /**
     * 括号生成
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        def(result, n, n, "");

        return result;
    }

    public void def(List<String> result, int left, int right, String curStr) {

        if (left == right && left == 0) {
            result.add(curStr);
            return;
        }
        //左括号选完之后，不能再选了
        if (left < 0)
            return;
        if (left > right)
            return;

        def(result, left - 1, right, curStr + "(");
        def(result, left, right - 1, curStr + ")");
    }

    /**
     * 数字全排列
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        trace(nums, new ArrayList<>(), result);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
        return result;
    }

    public static void trace(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (nums.length == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            trace(nums, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return result;

        for (int i = 0; i < nums.length; i++) {
            List<Integer> init = new LinkedList<>();
            init.add(nums[i]);
            result.add(init);
        }

        while (result.peek().size() != nums.length) {
            List<Integer> current = result.poll();
            for (int i = 0; i < nums.length; i++) {
                if (current.contains(nums[i]))
                    continue;
                List<Integer> addCurrent = new LinkedList<>();
//                if (!current.contains(Integer.MIN_VALUE))
                addCurrent.addAll(current);
                addCurrent.add(nums[i]);
                result.add(addCurrent);
            }
        }

        return result;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        List<Integer> init = new LinkedList<>();
        result.add(init);
        int index = 0;
        while (result.size() > index) {
            List<Integer> current = result.get(index);

            for (int i = 0; i < nums.length; i++) {
                if (current.contains(nums[i]))
                    continue;

                List<Integer> add = new LinkedList<>();
                add.addAll(current);
                add.add(nums[i]);
                result.add(add);
            }
            index++;
        }

        return result;
    }

    public static List<List<Integer>> subsets1(int[] nums) {

        ArrayList<List<Integer>> result = new ArrayList<>();


        tracing(nums, result, new ArrayList<>(), 0);

        return result;
    }

    public static void tracing(int[] nums, List<List<Integer>> result, List<Integer> res, int start) {

        result.add(new ArrayList<>(res));

        for (int i = start; i < nums.length; i++) {
            res.add(nums[i]);
            tracing(nums, result, res, i + 1);

            res.remove(res.size() - 1);
        }
    }


    /**
     * 单词搜索
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        return exist(board, word, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE,word.charAt(0)==board[0][0]);
    }

    /**
     * 问题1. 处理回路的方式
     * 问题2. 起点问题
     * @param board
     * @param word
     * @param row
     * @param column
     * @param oldRow
     * @param oldColumn
     * @param used
     * @return
     */
    public static boolean exist(char[][] board, String word, int row, int column, int oldRow, int oldColumn,boolean used) {

        if (word == "" || word.length() == 0)
            return true;

        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length)
            return false;
        if (row != 0 && column != 0 && word.charAt(0) != board[row][column])
            return false;


        if (board.length == row && board[0].length == column)
            return false;
        String newWord = word;
        if (word.charAt(0) == board[row][column])
            newWord = word.substring(1);

        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;
        if (!(row - 1 == oldRow && column == oldColumn) || !used)
            up = exist(board, newWord, row - 1, column, row, column,newWord!=word);//上

        if (!(row + 1 == oldRow && column == oldColumn) || !used)
            down = exist(board, newWord, row + 1, column, row, column,newWord!=word);//下
        if (!(column - 1 == oldColumn && row == oldRow)|| !used)
            left = exist(board, newWord, row, column - 1, row, column,newWord!=word);//左
        if (!(row == oldRow && column + 1 == oldColumn)|| !used)
            right = exist(board, newWord, row, column + 1, row, column,newWord!=word);//右

        return up || down || left || right;
    }


    public static boolean exist1(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board,word.toCharArray(),i,j,0))
                    return true;
            }
        }
       return false;
    }
    static boolean  dfs(char[][] board,char[] words,int i,int j,int index){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=words[index])
            return false;
        if(index==words.length-1)
            return true;
        char temp=board[i][j];
        board[i][j]='.';
        boolean result=
                dfs(board,words,i+1,j,index+1)
                || dfs(board,words,i-1,j,index+1)
                || dfs(board,words,i,j-1,index+1)
                || dfs(board,words,i,j+1,index+1);

        board[i][j]=temp;

        return result;
    }

}





































