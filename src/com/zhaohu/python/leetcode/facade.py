from itertools import count


class Solution(object):
    def countAndSay(self, n):
        start = "1"
        for i in range(n-1):
            count = 0
            current = start[0]
            result = ""
            for str1 in start:
                if(str1 != current):
                    result += (str(count)+current)
                    count = 0
                    current = str1
                    count += 1
                else:
                    count += 1
            else:
                result += str(count)
                result += current
            start = result
        return start


solution = Solution()
print(solution.countAndSay(5))
