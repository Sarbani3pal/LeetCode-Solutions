class Solution {
    public boolean isPalindrome(ListNode head) {
        
        
        ListNode mid = findMid(head);
        ListNode newHead = reverseMid(mid);
        
        boolean flag = true;
        while(newHead!=null){
            if(head.val!=newHead.val){
                flag = false;
                break;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return flag;
    }
    
    public ListNode findMid(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
    }
    
    public ListNode reverseMid(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode forward = null;
        
        while(curr!=null){
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

}
