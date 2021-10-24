package ProgrammingHomework.exercises01;

public class ReverseList {
    ListNode reverseList(ListNode head) {
        //反转链表，使用递归与迭代两种方式实现
        if(head== null || head.next== null){
            return head;
        }
        //首先使用迭代的方法实现
        ListNode ans=head;
        ListNode pre=head;
        ListNode current=pre.next;
        ListNode next=current.next;
        while (current!= null){
            current.next=pre;
            pre=current;
            current=next;
            if(next!= null){
                next=next.next;
            }
        }
        ans.next= null;
        return pre;
//递归做法
//        if(head== null || head.next== null){
//            return head;
//        }
//        ListNode newHead= reverseList(head.next);
//        head.next.next=head;
//        head.next= null;
//        return newHead;
    }
}
