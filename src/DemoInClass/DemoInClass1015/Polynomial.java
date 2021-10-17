package DemoInClass.DemoInClass1015;


public class Polynomial {
    private Term first;
    //构造函数，建立空链表
    public Polynomial(){
        first=new Term(0,-1,null);//相当于设置表头节点
    }

    public Term getHead(){
        return first;//获取多项式链表的表头指针
    }
    //求多项式的最高次数,默认链表按照指数大小升序排列
    private int maxOrder(){
        Term current=first;
        while (current.next!=null){
            current=current.next;
        }

        return current.exp;
    }


    //多项式的加法
    public Polynomial add(Polynomial A,Polynomial B){
        //定义三个指针进行调整与计算
        Term pa,pb,p,pc;
        double temp;//临时存放系数
        Polynomial C=new Polynomial();
        pc=C.first;
        pa=A.getHead().next;
        pb=B.getHead().next;
        while (pa!=null && pb!=null){
            if(pa.exp==pb.exp){
                temp= pa.coef+ pb.coef;
                if(temp!=0){
                    pc=pc.InsertAfter(temp, pa.exp);
                }
                pa=pa.next;
                pb=pb.next;
            }else if(pa.exp<pb.exp){
                pc=pc.InsertAfter(pa.coef, pc.exp);
                pa=pa.next;
            }else {
                pc=pc.InsertAfter(pb.coef, pb.exp);
                pb=pb.next;
            }
        }
        //使用P指向剩余链表的地址
        if(pa!=null){
            p=pa;
        }else {
            p=pb;
        }
        while (p!=null){
            pc=pc.InsertAfter(p.coef,p.exp);
            p=p.next;
        }
        return C;
    }
    //实现两个一元多项式相乘











}

//多项式节点的定义
class Term{
    double coef;//多项式的系数
    int exp;//多项式的指数
    Term next;//指向下一个项
    //构造函数
    public Term(double c,int e,Term next){
        this.coef=c;
        this.exp=e;
        this.next=next;
    }
    public Term InsertAfter(double c,int e){
        next=new Term(c,e,next);
        return next;
    }
}
