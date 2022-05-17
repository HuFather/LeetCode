from operator import index
from turtle import right
from unittest import result


class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        index=0
        i=0
        j=0
        while i < n and j<m :
            if(nums1[index]>nums2[i]):
                nums1.insert(index,nums2[i])
                nums1.pop()
                i+=1
            else:
                j+=1
            index+=1
        if(i<n):
            while i<n:
                nums1.insert(index,nums2[i])
                nums1.pop()
                i+=1
                index+=1
    
    def firstBadVersion(self,n):
        # if(n==1):
        #     return 0 if isBadVersion(1)  else 1
        return self.hhh(1,n)
        
    def hhh(self,start,end):
        middle=(start+end)//2
        
        if(start+1==end and not self.isBadVersion(start) and self.isBadVersion(end)):
            return start
        elif start ==end :
            return start-1 if self.isBadVersion(start)  else start

        result=0
        if(self.isBadVersion(middle)):
            result =self.hhh(start,middle)
        else:
            result =self.hhh(middle,end)
        return result

    def hhhh(self,n):
        start,end=0,n
        while(start<end):
            middle=start+(end-start)//2
            if(not isBadVersion(middle)):
                start=middle+1
            else:
                end=middle
        return start
            
        

    def isBadVersion(self,n):
        if(n>=1):
            return True
        else:
            return False

        


solution=Solution()
nums1=[1,2,3,0,0,0]
# solution.merge(nums1,3,[2,5,6],3)
solution.firstBadVersion(2)