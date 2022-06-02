package com.zhaohu.medium.lists;

import java.util.logging.Level;

/**
 * @creator : zhaohu
 * @date : 5/31/2022
 * @description :
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.test();
    }

    /**
     * 逆序数字和
     * 相加进位
     * 移除末尾的0
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode dummyNode=new ListNode();
        ListNode preNode=dummyNode;
        while (l1!=null || l2!=null || carry!=0 ){
            int sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            preNode.next=new ListNode(sum%10);
            carry=sum/10;

            preNode=preNode.next;
        }

        return dummyNode.next;

    }

    public void test(){
        Solution solution=new Solution();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        solution.oddEvenList(l1);
    }

    public  ListNode oddEvenList(ListNode head) {
        ListNode oddDumpNode=new ListNode();
        ListNode evenDumpNode=new ListNode();
        ListNode oddCurrent=oddDumpNode;
        ListNode eventNode=evenDumpNode;
        boolean isOdd=true;
        while (head!=null){
            if(isOdd){
                oddCurrent.next=head;
                oddCurrent=oddCurrent.next;
            }
            else {
                eventNode.next=head;
                eventNode=eventNode.next;
            }

            head=head.next;

            isOdd=!isOdd;
        }
        if( !isOdd){
            eventNode.next=null;
        }
        oddCurrent.next=evenDumpNode.next;


        return oddDumpNode.next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA=0;
        int lengthB=0;
        ListNode a=headA;
        ListNode b=headB;
        while (a!=null || b!=null){
            if(a!=null){
                lengthA++;
                a=a.next;
            }
            if(b!=null){
                lengthB++;
                b=b.next;
            }
        }
        a=headA;
        b=headB;
        if(lengthA>lengthB){
            while (lengthA>lengthB){
                a=a.next;
                lengthA--;
            }
        }
        if(lengthA<lengthB){
            while (lengthA<lengthB){
                b=b.next;
                lengthB--;
            }
        }
        ListNode result=null;
        while (a!=null){
            if(a==b){
                result=a;
                break;
            }else {
                a=a.next;
                b=b.next;
            }
        }

        return result;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}

