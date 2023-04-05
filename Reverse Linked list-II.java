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
   public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right)return head;
        ListNode l=null,r=null,startRev=null,endRev=null,curr=head,prev=null;
        // 1->2->3->4->5->null. 
        // left=2,right=4
        // l=node(1), r=node(5), startRev=node(2), endRev=node(4)
        int count=1;
        while(curr!=null){
            if(count==left-1)
                l=curr;
            else if(count==right+1)
                r=curr;
            else if(count==left)
                startRev=curr;
             else if(count==right)
                endRev=curr;
            if(count>left && count<=right){
                //reverse between left and right logic
                ListNode tnext=curr.next;
                curr.next=prev;
                prev=curr;
                curr=tnext;
            }else{
                //move to next if not between
                prev=curr;
                curr=curr.next;
            }
     
            
            count++;
        }
        //the next node of node where reverse starts, should be the next node of nodeAt(right) 
        startRev.next=r;
        //if reverse starts from first node then prev of that node will be null -> nedRev will be the first node
        //otherwise the node after which reverse starts should point to the node where reverse ends
        if(l!=null)l.next=endRev;
        
        //if left==1 -> head=endRev node where reverse stops 
        return left>1? head:endRev;
    }
}