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
        swap(list,k-1,list.size()-k);
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for(int i=0;i<list.size();i++){
            temp.next=list.get(i);
            temp  = temp.next;
        }
        return dummy.next; 
    }
    public void swap(ArrayList<ListNode> ans,int i,int j){
        int temp = ans.get(i).val;
        ans.get(i).val = ans.get(j).val;
        ans.get(j).val= temp;
    }
}