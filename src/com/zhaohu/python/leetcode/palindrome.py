class Solution(object):
    def isPalindrome(self,s:str):
        start,end=0,len(s)-1
        while(start<end):
            if(not s[start].isalnum()):
                start+=1
                continue
            if(not s[end].isalnum()):
                end-=1
                continue
            if(s[end].lower()!=s[start].lower()):
                return False
            start+=1
            end-=1
        
        return True


solution=Solution()
result=solution.isPalindrome('A man, a plan, a canal: Panama')
print(result)
            
