package DemoInClass.DemoInClass1015;

public class Josephus {
    CircularLinkedList JosephusCircle=new CircularLinkedList();
    //构建约瑟夫环
    public void constructJosephusCircle(int n){
        JosephusCircle=JosephusCircle.constructCircularLinkedList(n);
    }
    /**
     * 模拟约瑟夫环运行过程
     * @param n the number of people
     * @param m the m-th man who will be killed
     * @return the men who will be killed
     */
    public LinkNode theManTobeKilled(int n,int m){
        //首先构建约瑟夫环
        constructJosephusCircle(n);
        //使用rear指针指向要出队的人的前面一个人，初始位置指向循环链表的首元节点
        LinkNode rear=JosephusCircle.dummyHead;
        for(int i=1;i<=n;i++){
            rear=rear.next;
        }
        //使用head指针，开始时指向首元结点，目的是指向第一个出队的人，便于最后的返回，head指针在整个模拟的过程中只会移动一次(第一个人出队的时候)
        LinkNode head=rear.next;
        //使用p指针指向会出队的每一个人，开始时指向首元结点
        LinkNode p=rear.next;
        //模拟过程如下
        //一共要出队n-1人，外层循环循环n-1次
        //我的这种设计不好,这里的表头节点其实是多余的
        for(int i=1;i<=n-1;i++){
            //内层循环模拟报数1~m
            for(int j=1;j<=m-1;j++){
                //调整rear指针，在内层循环结束时指向要出队的人的前一个人
                rear=rear.next;

            }
            if(i==1){
                //第一次调整head指针，指向第一个出队的人
                head=rear.next;

                p=head;
            }else {
                p.next=rear.next;

                p=p.next;
            }
            rear.next=p.next;

        }
        p.next=rear;
        rear.next=null;
        return head;
    }
    public static void main(String[] args) {
        Josephus josephus=new Josephus();
        LinkNode res= josephus.theManTobeKilled(80,3);
        LinkNode ptr=res;
        while (ptr!=null){
            System.out.println(ptr.data);
            ptr=ptr.next;
        }
    }
}
//构造链表的节点类
//为了解决问题的需要，不使用泛型，节点的数值域类型默认为int
class LinkNode{
    public int data;
    public LinkNode next;
    //默认构造函数
    public LinkNode(){
        this.data=0;
        this.next=null;
    }
    //自定义构造函数1,初始化data域与next指针
    public LinkNode(int data, LinkNode next){
        this.data=data;
        this.next=next;
    }
    //自定义构造函数2,初始化data域，将next指针设成空
    public LinkNode(int data){
        this.data=data;
        this.next=null;
    }
}
//构建带表头节点的循环链表
class CircularLinkedList{
    //成员变量为一个表头节点
    public LinkNode dummyHead;
    //默认构造函数
    public CircularLinkedList(){
        this.dummyHead=new LinkNode(-1);
        this.dummyHead.next=dummyHead;
    }
    //根据n构造1~n的带表头节点的循环链表
    public CircularLinkedList constructCircularLinkedList(int n){
        CircularLinkedList result=new CircularLinkedList();
        LinkNode ptr=result.dummyHead;
        for(int i=1;i<=n;i++){
            LinkNode temp=new LinkNode(i);
            ptr.next=temp;
            ptr=ptr.next;
        }
        //这边的表头节点其实是虚假的
        ptr.next=result.dummyHead.next;
        return result;
    }
}




