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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode selectedNode=null, newListHead=null;
        if(list1 == null && list2 == null) return selectedNode;

        selectedNode = new ListNode();
        newListHead=selectedNode;
    

    while(list1!=null || list2 !=null ) {

        if(list1==null && list2 != null) {

            selectedNode.next = list2;
            break;
        }

        if(list1!=null && list2 == null) {

            selectedNode.next = list1;
            break;

        }

        if(list1.val < list2.val){
            selectedNode.next = list1;
            selectedNode=selectedNode.next;
            list1 = list1.next;
        } else {
            selectedNode.next= list2;
            selectedNode=selectedNode.next;
            list2 = list2.next;
        }
    }

    return newListHead.next;
        
    }
}