class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if(len(s) != len(t)):
            return False
        count = 0
        map = [0] * 26
        for i in range(len(s)):
            map[(ord(s[i])-97)] += 1
          
            if(map[(ord(s[i])-97)] == 1):
                count = count+1

            map[(ord(t[i])-97)] -= 1
            
            if(map[(ord(t[i])-97)] == 0):
                count = count-1

        return count == 0


soulution = Solution()
soulution.isAnagram('anagram', 'nagaram')
