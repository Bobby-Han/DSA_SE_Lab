package DemoInClass.DemoInClass1015;

public class StaticList {
    int maxSize=100;

    SLinkNode[] ele=new SLinkNode[maxSize];
    int avil;//当前可分配空间的首地址
    //对avil的理解，比如ele的前k个元素都填满了，则avil就是第k+1个位置，因为那里还没有填元素

    //初始化静态链表
    public void InitList(){
        ele[0].next=-1;//相当于设置表头节点
        avil=1;//相当于从首元结点开始构建真实的链表
        for(int i=1;i<maxSize-1;i++){
            //相当于一个串一个
            ele[i].next=i+1;
        }
        //最后收尾
        ele[maxSize-1].next=-1;
    }
    //求解静态链表的有效长度
    public int Length(){
        int p=ele[0].next;
        int i=0;
        while (p!=-1){
            i++;
            p=ele[p].next;
        }
        return i;
    }
    //在链表中查找第i个节点,返回的是节点的编号
    //注意这边的理解：ele[i]不一定就是链表的第i个元素,应为指针不一定正好是一个接一个
    public int Locate(int i){
        if(i<0){
            return -1;
        }
        if(i==0){
            return 0;
        }
        int j=0,p=ele[0].next;
        while (p!=-1 && j<i){
            p=ele[p].next;
            j++;
        }
        return p;
    }
    //在链表尾部添加一个新的节点
    public boolean Append(int x){
        if(avil==-1){
            return false;
        }
        //首先得到第一个可以填元素的位置
        int q=avil;
        avil=ele[avil].next;
        //填上要添加的元素
        ele[q].data=x;
        ele[q].next=-1;
        //从表头节点开始遍历，找到链表尾部
       int p=0;
       while (ele[p].next!=-1){
           p=ele[p].next;
       }
       //连接
       ele[p].next=q;
       return true;
    }
    //静态链表的插入
    public boolean Insert(int i,int x){
        //在链表的第i个节点之后插入值x
        int p=Locate(i);
        if(p==-1){
            return false;
        }
        //得到可以填元素的位置
        int q=avil;
        avil=ele[avil].next;
        ele[q].data=x;
        ele[q].next=ele[p].next;
        ele[p].next=q;
        return true;
    }
    //删除第i个节点
    public boolean Remove(int i){
        //需要找到要删的节点的前继
        int p=Locate(i-1);
        if(p==-1)
        {
            return false;
        }
        int q=ele[p].next;
        //前继的后继改为原来前继的后继的后继
        ele[p].next=ele[q].next;
        ele[q].next=avil;
        //此时因为删除了第i个节点，所以这个节点变成了第一个可以填元素的节点
        avil=q;
        return true;
    }
    //综上所述，这里的avil是一个很精巧的设计
    //总的来说，使用数组实现的静态链表是很精巧的设计，在实际解题中使用静态链表解题会比使用指针维护的动态链表更快
    //但是静态链表的操作有点复杂，需要把逻辑理顺
}
class SLinkNode{
    //可以将该类看成是一个结构体
    int data;//节点数据
    int next;//节点的next指针
}
