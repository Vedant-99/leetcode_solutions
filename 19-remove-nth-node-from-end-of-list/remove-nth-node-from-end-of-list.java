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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode revhead = reverse(head);
        if(n==1){
            revhead = revhead.next;
            return reverse(revhead);
        }
        ListNode temp = revhead;
        for(int i=1;i<n-1;i++){
            temp = temp.next;

        }
        if(temp.next!=null){
        temp.next = temp.next.next;
        }
        return reverse(revhead);
    }
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode forw=null;
        while(curr!=null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
}
