/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
       public ListNode oddEvenList(ListNode head) {
     if (head == null) {
      return null;
     }
     ListNode oddHead = new ListNode(0);
     ListNode oddIt = oddHead;
     ListNode evenHead = new ListNode(0);
     ListNode evenIt = evenHead;
     int toggle = 1;
     while (head != null) {
      if ((toggle ^ 0) == 1) {
       oddIt.next = head;
       oddIt = oddIt.next;
      } else {
       evenIt.next = head;
       evenIt = evenIt.next;
      }
      head = head.next;
      toggle ^= 1;
     }
     evenIt.next = null;
     oddIt.next = evenHead.next;
     return oddHead.next;
    }
}