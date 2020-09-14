package com.tjpu.Algorithm_Code.LeetCode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr=head;
        while(curr!=null&&curr.next!=null){
            if(curr.val==curr.next.val){
                curr.next=curr.next.next;
            }else{
                curr=curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(1);
        ListNode n3=new ListNode(2);
        n1.next=n2;
        n2.next=n3;

        DeleteDuplicates demo =new DeleteDuplicates();
        demo.deleteDuplicates(n1);
        System.out.println(n1.toString());

    }
}