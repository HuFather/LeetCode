from queue import Queue
import queue


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


