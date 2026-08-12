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
    public ListNode deleteDuplicates(ListNode head) {
        
        Set<Integer> set = new TreeSet<>();
        ListNode temp = head;
        while(temp!=null){
            set.add(temp.val);
            temp=temp.next;
        }
        ListNode newHead = new ListNode(-1);
        temp = newHead;
        
        for(int val:set){
            temp.next   =  new ListNode(val);            
            temp= temp.next;
        }
        return newHead.next;

    }
}