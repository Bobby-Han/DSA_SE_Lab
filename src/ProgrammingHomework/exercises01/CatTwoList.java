package ProgrammingHomework.exercises01;
public class CatTwoList {
//    方法一：使用HashSet，存储链表A的所有节点，之后遍历链表B，返回第一个相交的节点
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        Set<ListNode> set=new HashSet<>();
//        ListNode pa=headA;
//        ListNode pb=headB;
//        while(pa!=null){
//            set.add(pa);
//            pa=pa.next;
//        }
//        while(pb!=null){
//            if(set.contains(pb)){
//                return pb;
//            }
//            pb=pb.next;
//        }
//        return null;
//    }

    //方法2，使用基本链表操作(双指针算法；具体证明见力扣)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
