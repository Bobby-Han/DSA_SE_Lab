package DemoInClass.DemoInClass1015;

import java.util.Scanner;
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
    //一元多项式的加法
    public static Polynomial add(Polynomial A,Polynomial B){
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
    //一元多项式相乘
    //这边设计的巧妙之处在于多开了一个result数组，用下标表示指数，数组的值表示系数
    public static Polynomial mul(Polynomial A,Polynomial B){
        Term pa,pb,pc;
        int AL,BL,i,k,maxExp;
        Polynomial C=new Polynomial();
        pc=C.getHead();
        AL=A.maxOrder();
        BL=B.maxOrder();
        if(AL!=-1 || BL!=-1){
            maxExp=AL+BL;
            double[] result=new double[maxExp+1];//存储对应的次数前的系数
            //初始化
            for(i=0;i<=maxExp;i++){
                result[i]=0.0;
            }
            pa=A.getHead().next;
            while (pa!=null){
                pb=B.getHead().next;
                while (pb!=null){
                    k= pb.exp+pa.exp;
                    //把符合条件的系数相加就是最终的系数
                    result[k]+= pa.coef*pb.coef;
                    pb=pb.next;
                }
                pa=pa.next;
            }
            for(i=0;i<=maxExp;i++){
                if(result[i]!=0.0){
                    pc=pc.InsertAfter(result[i],i);
                }
            }
        }
        return C;
    }
    public static void main(String[] args) {
        Polynomial A=new Polynomial();
        Polynomial B=new Polynomial();
        Term ptra=A.getHead();
        Term ptrb=B.getHead();
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<5;i++){
            double temp=scanner.nextDouble();
            ptra=ptra.InsertAfter(temp,i);
        }
        for(int i=0;i<5;i++){
            double temp=scanner.nextDouble();
            ptrb=ptrb.InsertAfter(temp,i);
        }
        Polynomial C=Polynomial.mul(A,B);
        Term ptrres=C.getHead().next;
        while (ptrres!=null){
            System.out.println(ptrres.coef+" "+ptrres.exp);
            ptrres=ptrres.next;
        }
    }
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
        //这里依旧是指向自身对象的指针
        //也就是自己调方法改变自己
        this.next=new Term(c,e,this.next);
        return next;
    }
}
