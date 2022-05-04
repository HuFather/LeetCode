import re


class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        dic = {}
        for st in s:
            if(dic.__contains__(st)):
                dic[st] = dic[st]+1
            else:
                dic[st] = 1

        for st in s:
            if(dic[st] == 1):
                return s.index(st)
        
        return -1


solution = Solution()
print(solution.firstUniqChar('loveleetcode'))
