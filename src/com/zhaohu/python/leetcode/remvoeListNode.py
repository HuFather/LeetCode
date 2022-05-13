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


    def reverseList(self,head):
        result=None
        while(head):
            current=head.next
            head.next=result
            result=head
            head=current
        return result




    def isPalindrome(self,head):
        slow=head
        fast=head
        while(fast and fast.next):
            slow=slow.next
            fast=fast.next.next
        sss=Solution()
        slow=sss.reverseList(slow)
        while(slow):
            if(head.val != slow.val):
                return False
            head=head.next
            slow=slow.next
        return True

    def hasCycle(self, head):
        """
        给你一个链表的头节点 head ，判断链表中是否有环。
        如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
        评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递
        如果链表中存在环 ，则返回 true 。 否则，返回 false
        """
        if head is None or head.next is None or head.next.next is None:
            return False
        slow=head
        fast=head
        while fast.next is not None and fast.next.next is not None:
            slow=slow.next
            fast=fast.next.next
            if(slow==fast):
                break
        
        if(fast is None or fast.next is None):
            return False
        if(slow==fast):
            return True
        return False

        


solution = Solution()
head = ListNode(1)
node1 = ListNode(2)
node2 = ListNode(2)
node3 = ListNode(1)
node4 = ListNode(5)
head.next = node1
node1.next = node2
node2.next = node3
# node3.next = node4
# solution.reverseList(head)
solution.isPalindrome(head)
