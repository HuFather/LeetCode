# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next

    def removeNthFromEnd(self, head, n):
        if(head is None or head.next is None):
            return None

        nextNode = head
        for i in range(n):
            nextNode = nextNode.next

        if nextNode is None:
            return head.next

        currentNode = head
        while nextNode.next is not None:
            currentNode = currentNode.next
            nextNode = nextNode.next
        currentNode.next = currentNode.next.next
        return head

    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        newHead = None
        while head is not None:
            current = head.next
            head.next = newHead
            newHead = head
            head = current

        return newHead

    def mergeTwoLists(self, list1, list2):
        """
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        if(list1 is None):
            return list2
        if(list2 is None):
            return list1

        result = ListNode(0)
        current = result
        while list1 is not None and list2 is not None:

            if(list1.val >= list2.val):
                current.next = list2
                list2 = list2.next
            else:
                current.next = list1
                list1 = list1.next
            current = current.next

        current.next = list1 if list2 is None else list2
        return result.next


solution = Solution()
head = ListNode(1)
node1 = ListNode(2)
node2 = ListNode(3)
node3 = ListNode(4)
node4 = ListNode(5)
# head.next = node1
# node1.next = node2
# node2.next = node3
# node3.next = node4
solution.mergeTwoLists(head, node1)
