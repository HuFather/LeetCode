import numbers


class Solution(object):
    def myAtoi(self, s):
        """
        :type s:str
        :rtype: int
        """
        s = s.strip()
        d = 0
        negative = 0
        for i in range(len(s)):
            str=s[i]
            if((str == '-' or str == '+') and i==0):
                negative = 1 if str == "+" else -1
            elif(str.isdigit()):
                d *= 10
                d += int(str)
            else:
                break

        if(negative ==0 ): negative=1
        return max(-2**31, min(d*negative, 2**31-1))


solution = Solution()
result = solution.myAtoi(" -42")
print(result)
