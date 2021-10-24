package ProgrammingHomework.exercises01;

public class SwapListNode2 {
    //实现双链表中两个节点的交换
    //交换第idx个和第idx+1个节点(idx从1开始计数，1表示双链表的head)
    public DoublyListNode swapPairs(DoublyListNode head,int idx){
        DoublyListNode dummyHead=new DoublyListNode(-1);
        dummyHead.next=head;
        head.prev=dummyHead;
        DoublyListNode ans=dummyHead;
        DoublyListNode ptr1=dummyHead;
        DoublyListNode ptr2=dummyHead;
        DoublyListNode ptr3=dummyHead;
        DoublyListNode ptr4=dummyHead;
        int count=0;
        while (count!=idx){
            ptr2=ptr2.next;
            count++;
        }
        ptr1=ptr2.prev;
        ptr3=ptr2.next;
        if(ptr3==null){
            ptr1.next=null;
            return ans.next;
        }
        ptr4=ptr3.next;
        ptr3.next=ptr2;
        ptr3.prev=ptr1;
        ptr2.next=ptr4;
        ptr2.prev=ptr3;
        ptr1.next=ptr3;
        if(ptr4!=null){
            ptr4.prev=ptr2;
        }
        return ans.next;
    }
    public static void main(String[] args) {
        SwapListNode2 swapListNode2=new SwapListNode2();
        DoublyListNode node1=new DoublyListNode(1,null,null);
        DoublyListNode node2=new DoublyListNode(2,null,null);
        DoublyListNode node3=new DoublyListNode(3,null,null);
        DoublyListNode node4=new DoublyListNode(4,null,null);
        DoublyListNode node5=new DoublyListNode(5,null,null);
        DoublyListNode node6=new DoublyListNode(6,null,null);
        DoublyListNode node7=new DoublyListNode(7,null,null);
        DoublyListNode node8=new DoublyListNode(8,null,null);
        DoublyListNode node9=new DoublyListNode(9,null,null);
        node1.next=node2;
        node2.prev=node1;
        node2.next=node3;
        node3.prev=node2;
        node3.next=node4;
        node4.prev=node3;
        node4.next=node5;
        node5.prev=node4;
        node5.next=node6;
        node6.prev=node5;
        node6.next=node7;
        node7.prev=node6;
        node7.next=node8;
        node8.prev=node7;
        node8.next=node9;
        node9.prev=node8;
        DoublyListNode ans= swapListNode2.swapPairs(node1,7);
        DoublyListNode ptr=ans;
        while (ptr!=null){
            System.out.print(ptr.val+" ");
            ptr=ptr.next;
        }
    }
}
// Definition for singly-linked list.
class DoublyListNode {
    int val;
    DoublyListNode next;
    DoublyListNode prev;
    DoublyListNode() {}
    DoublyListNode(int val) { this.val = val; }
    DoublyListNode(int val, DoublyListNode next,DoublyListNode prev) { this.val = val; this.next = next; this.prev=prev;}
}
