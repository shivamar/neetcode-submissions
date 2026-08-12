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
    public ListNode mergeKLists(ListNode[] lists) {      
        int k = lists.length;  
        if(k==0) return null;
        if(k==1) return lists[0];

        //PriorityQueue<ListNode> pQueue = new PriorityQueue<ListNode>((a,b) -> Integer.compare(a.val,b.val));
        PriorityQueue<ListNode> pQueue = new PriorityQueue<ListNode>(Comparator.comparingInt(a -> a.val));

        for(ListNode node :  lists){

            if(node == null) continue;
            pQueue.offer(node);
        }

        ListNode dummy = new ListNode(0),curr = dummy;

        while(!pQueue.isEmpty()){
            if(curr.next != null) pQueue.offer(curr.next);

            ListNode next = pQueue.poll();
            curr.next=next;
            curr=next;
        }

        return dummy.next;
    }
}
