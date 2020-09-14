package com.Test;




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ListNode{
    int value;
    ListNode next;
    public ListNode(int x) {
        this.value = x;
        next=null;
    }
}
class Main7 {
    public ListNode delectKNode(ListNode node,int k){
        ListNode head=node.next;
        ListNode pre=node;
        while (head!=null&&(k-2)!=0){
            head=head.next;
            pre=pre.next;
            k--;
        }
        pre.next=head.next;
        return node;
    }


    public static void main(String[] args) {
        Main7 main =new Main7();
        Scanner in =new Scanner(System.in);
        String number = in.next();
        String delK= in.next();
        System.out.println(number+"--"+delK);
        ListNode node=new ListNode(0);
        ListNode head=node;
        for (int i=0;i<Integer.parseInt(number);i++){
            int inNum=in.nextInt();
            head.next=new ListNode(inNum);
            head=head.next;
        }
        List<Integer> ans =new ArrayList<>();
        ListNode res =main.delectKNode(node.next,Integer.parseInt(delK));
        while (res!=null){
            ans.add(res.value);
            res=res.next;
        }
        System.out.println(ans);
    }

}
