package DemoInClass.DemoInClass1207;
public class UFSets {
    //并查集支持3种操作
    //1.Union(Root1,Root2):将子集Root2并入集合Root1中。要求Root1与Root2互不相交，否则不执行合并
    //2.Find(x):搜索单元素x所在的集合，并返回该集合的名字
    //3.UFSets(s):构造函数，将并查集(用UFSets命名)中s个元素初始化为s个只有一个单元素的子集合
    int[] parent;
    int size;
    public UFSets(int size){
        this.parent =new int[size];
        this.size=size;
        //将parent里的各个值初始化为-1，表示每个元素自成一个单元素集合
        for(int i=0;i<size;i++){
            parent[i]=-1;
        }
    }

    //寻找包含元素x的树的根
    public int Find(int x){
        //思想:不断地找爸爸
        //可以使用递归写法
        while (parent[x]>=0){
            x=parent[x];
        }
        return x;
    }
    public void Union(int Root1,int Root2){
        parent[Root1]+=parent[Root2];
        //将Root2连接到另一根Root1下面
        parent[Root2]=Root1;
    }
}
