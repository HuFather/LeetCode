from queue import Queue
import queue
import sys


class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    def maxDepth(self, root):
        """
        给定一个二叉树，找出其最大深度。
        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
        说明:叶子节点是指没有子节点的节点。
        示例：
        给定二叉树 [3,9,20,null,null,15,7]
        """
        if(root is None):
            return 0

        numLeft = self.maxDepth(root.left)
        numRight = self.maxDepth(root.right)
        return max(numLeft, numRight)+1

    def maxDepthBFS(self, root):
        if(root is None):
            return 0
        queue = list()
        queue.append(root)
        num = 0
        while(len(queue) > 0):
            size = len(queue)
            for s in range(size):
                temp = queue[0]
                del temp
                if(temp.left is not None):
                    queue.append(temp.left)
                if(temp.right is not None):
                    queue.append(temp.right)

            num += 1
        return num

    def isValidBST(self, root):
        """
        给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
        有效 二叉搜索树定义如下：
        节点的左子树只包含 小于 当前节点的数。
        节点的右子树只包含 大于 当前节点的数。
        所有左子树和右子树自身必须也是二叉搜索树。
        5,4,6,n,n,3,7 

        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
            if (root == null)
                return true;
            //每个节点如果超过这个范围，直接返回false
            if (root.val >= maxVal || root.val <= minVal)
                return false;
            //这里再分别以左右两个子节点分别判断，
            //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
            //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
            return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
        }

        """
        return self.isValidBST(root, -sys.maxint-1, sys.maxint)

    def isValidBST(self, root, minVal, maxVal):
        if root is None:
            return True
        if root.val >= maxVal or root.val <= minVal:
            return False
        return self.isValidBST(root.left, minVal, root.val) and self.isValidBST(root.right, root.val, maxVal)
