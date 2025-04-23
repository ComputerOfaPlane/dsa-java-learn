# code to convert roman numbers to integer equivalent
"""
my approach:
create a dictionary with required stuffs
keep adding the stuff, if the forward stuff is more than the previous then deduct the previous stuff
"""
class Solution(object):
    def romanToInt(self, s):
        ans = 0
        k = s + '@'
        dict = {'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000, '@':0}
        j=1
        for i in s:
            if dict[k[j]] <= dict[i]:
                ans+=dict[i]
            else:
                ans-=dict[i]
            j+=1
        return ans