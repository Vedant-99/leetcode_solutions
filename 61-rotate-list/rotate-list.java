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
    public ListNode rotateRight(ListNode head, int k) {
        if(head ==null || head.next==null) return head;
        int len =0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        k= k%len;
        if(k==0) return head;

        ListNode fast =head,slow=head;
        for(int i=1;i<=k;i++) fast = fast.next;
        while(fast.next!=null){
            slow= slow.next;
            fast= fast.next;
        }
        ListNode newHead = slow.next;
        slow.next= null;
        fast.next = head;

        
        return newHead;

    }
}