package ProgrammingHomework.exercises00;

import org.junit.Assert;
import org.junit.Test;

public class LengthOfLinkedList {
    public int calculateLength(LinkedList linkedList){
        if(linkedList==null){
            return 0;
        }
        return 1+calculateLength(linkedList.getNext());
    }
    @Test
    public void test1(){
        LinkedList list1=new LinkedList(1,null);
        LinkedList list2=new LinkedList(2,null);
        list1.setNext(list2);
        int expected=2;
        Assert.assertEquals(2,calculateLength(list1));
    }
}
class LinkedList{

    private int ele;
    private LinkedList next;
    public LinkedList(int ele,LinkedList next){
        this.ele=ele;
        this.next=next;
    }
    public void setNext(LinkedList next) {
        this.next = next;
    }

    public LinkedList getNext() {
        return next;
    }
}