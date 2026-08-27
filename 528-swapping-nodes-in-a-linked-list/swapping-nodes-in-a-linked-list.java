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
    public ListNode swapNodes(ListNode head, int k) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode t = head;
        while(t!=null){
            list.add(t);
            t = t.next;
        }
        int n = list.size();
        ListNode first = list.get(k-1);
        ListNode second = list.get(n-k);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}