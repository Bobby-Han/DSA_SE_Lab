package DemoInClass.DemoInClass1207;

public class HashTable {
    //对应PPT第五章哈希表
    //散列表的题目多看📕
    //书后有课后习题
    //重点掌握解决冲突的闭散列(线性探测、二次探测、双散列)和开散列方法，会算搜索成功的平均搜索长度
    int divisor;//散列函数的除数
    int currentSize;//当前的桶数
    int tableSize;//最大的桶数
    int[] ht;//散列表的存储数组
    boolean[] info;//存储每个桶的状态，false表示桶为空
    //注意，这里说的桶其实就是数组的每一个位
    //构造函数
    public HashTable(int divisor,int size){
        this.divisor=divisor;
        this.tableSize=size;
        this.currentSize=0;
        ht=new int[tableSize];
        this.info=new boolean[tableSize];
    }
    //使用线性探测法的搜索算法
    //如果搜索成功，返回该元素的位置，如果搜索不成功，返回插入点
    public int LinearFindPos(int key){
        //计算初始桶号
        int i=key%divisor;
        int j=i;//j是检测下一空桶的下标
        do {
            if(!info[j] || info[j] && ht[j]==key){
                return j;
            }else {
                j=(j+1)%tableSize;
            }
        }while (j!=i);
        //循环退出的条件是j=i，此时表示已经转了一圈，相当于表已经满了，搜索失败
        return j;
    }
    //使用线性探测法在散列表中搜索元素key，如果存在，返回true，否则返回false
    public boolean Search(int key){
        //使用上面的方法找到对应的下标
        int i=LinearFindPos(key);
        //如果当前桶不空且当前桶的元素就是key,表示查找成功
        return info[i] && ht[i] == key;
    }

    //散列表的插入

    /**
     * 在散列表中插入一个元素
     * @param key 待插入的关键码
     * @return 一个布尔值，表示是否成功插入
     */
    public boolean Insert(int key){
        //找到可能可以插入的位置
        int index=LinearFindPos(key);
        //对这个位置进行进一步判断，判断是不是可以真正插入关键码
        //1.如果这个位置的状态是空，直接插入
        if(!info[index]){
            ht[index]=key;
            info[index]=true;
            //不要忘记将currentSize+1
            currentSize++;
            return true;
        }
        //2.如果这个位置已经有元素了，并且这个元素就是key，不要插入
        if(info[index] && ht[index]==key) {
            System.out.println("散列表中已经有这个元素了，不需要插入！");
            return false;
        }
        System.out.println("散列表已满，插入失败！");
        return false;
    }

    /**
     * 在散列表中删除某个元素
     * @param key 关键码
     * @return 是否成功删除
     */
    public boolean Remove(int key){
        int i=LinearFindPos(key);
        //如果找到了key
        if(info[i] && ht[i]==key){
            info[i]=false;
            currentSize--;
            return true;
        }
        return false;
    }
    //注意散列表题目可能回让我们求解搜索成功的平均搜索长度
    //对于每一个元素的平均搜索长度，对于线性探测法，找到一个元素的比较次数与当初将它存入时的探测次数相同
    //简单的说就是要从一开时哈希的那个哈希值往后找几次才能找到

    //线性探测法的堆积问题
    //不同的探测序列的关键码占据了可利用的空桶，找寻某一关键码需要经历不同的探测序列的元素

    //下面考虑使用二次探测法
    //这边要注意一下没有找到时前一个位置与后一个位置的关系
    //是加上(2i-1)或者减去(2i-1)
    public int QuadraticFindPos(int key){
        int index=key%divisor;//计算出初始桶号
        int k=0,odd=0,j;//k为探测次数,odd是控制加减标志
        while(info[index] && ht[index]!=key){
            if(odd==0){
                k++;
                index=(index+2*k-1)%tableSize;
                odd=1;
            }else {
                index=(index-(2*k-1))%tableSize;
                odd=0;
                if(index<0){
                    index+=tableSize;
                }
            }
        }
        return index;
    }
    //二次探测插入删除暂时不写

    //双散列算法
    //内容见PPT和📕

    //处理冲突的开散列算法
    //具体思路见📕和PPT
    //大体思路就是使用链表来存储每个位置的值


























}
