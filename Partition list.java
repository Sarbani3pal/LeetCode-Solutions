class Solution {
public ListNode partition(ListNode head, int x) {
if(head==null || head.next == null)return head;
ListNode small = new ListNode();
ListNode higher = new ListNode();
ListNode smallHead = small, higherHead = higher;

    while(head != null)
    {
        //if small
        if(head.val<x)
        {
            small.next = head;
            small = small.next;
        }else{
            higher.next = head;
            higher = higher.next;
        }
        head = head.next;
    }
    higher.next = null;
    small.next = higherHead.next;
    return smallHead.next;
}
}