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
    public ListNode reverse(ListNode head){
        ListNode curr =head;
        ListNode forw= null,prev=null;
        while(curr !=null){
            forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        ListNode t1=l1;
        l2= reverse(l2);
        ListNode t2=l2;
        int carry=0;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(t1!=null || t2!=null){
            int sum=carry;
            if(t1!=null){
                sum +=t1.val;
                t1= t1.next;
            }
            if(t2!=null){
                sum +=t2.val;
                t2= t2.next;
            }
            carry=sum/10;
            tail.next = new ListNode(sum%10);
            tail=tail.next;
            }
            if(carry != 0) tail.next = new ListNode(carry);
            return reverse(dummy.next);

        }


    }