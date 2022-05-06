class Solution(object):
    def strStr(self, haystack, needle):
        start = 0
        while(start < len(haystack)):
            for i in range(len(needle)):
                if(start+i > len(haystack)-1):
                    return -1
                if(not needle[i] == haystack[start+i]):
                    break
            else:
                return start
            start += 1
        return -1


solution = Solution()
print(solution.strStr("abc", "c"))
