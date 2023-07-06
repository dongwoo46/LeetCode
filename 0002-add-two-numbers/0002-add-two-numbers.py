# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        result = ListNode()
        l1_value,l2_value = 0,0
        numb = 1
        while l1:
            l1_value += numb*l1.val
            l1 = l1.next
            numb*=10
        
        numb=1
        while l2:
            l2_value +=numb*l2.val
            l2 = l2.next
            numb*=10
        
        ans = list(str(l1_value+l2_value))
        
        result = ListNode(int(ans[-1]))
        current = result
        for i in range(len(ans)-2,-1,-1):
            temp = ListNode(int(ans[i]))
            current.next = temp
            current = temp
        return result
        
        