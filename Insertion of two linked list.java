//Insertion of two linked list

class Solution {
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
int sizeA = 0;
int sizeB = 0;

  ListNode tempA = headA;
  ListNode tempB = headB;
  
  while(tempA!= null){
      
      sizeA++;
      tempA = tempA.next;
  }
  
  while(tempB!= null){
      
      sizeB++;
      tempB = tempB.next;
  }
// System.out.println(sizeA);
// System.out.println(sizeB);

  int it = Math.abs(sizeA-sizeB);
  
  if(sizeA>sizeB){
      while(it!=0){
          headA = headA.next;
          it--;
      }
  }
  if(sizeB>sizeA){
      while(it!=0){
          headB = headB.next;
          it--;
      }
  }
  
  while(headA != headB){
      // System.out.println(headA.val);
      // System.out.println(headB.val);
      headA = headA.next;
      headB = headB.next;
  }
//

  return headB;
}
}