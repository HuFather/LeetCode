class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if(not strs or len(strs) == 0):
            return 0

        str = strs[0]
        i = 1
        while(i < len(strs)):
            current = strs[i]
            while(current.find(str) != 0):
                str = str[0:len(str)-1]
            i += 1
        return str


solution = Solution()
result = solution.longestCommonPrefix(["flower", "flow", "flight"])
print(result)
