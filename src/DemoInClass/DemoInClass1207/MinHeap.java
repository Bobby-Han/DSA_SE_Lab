package DemoInClass.DemoInClass1207;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class MinHeap implements Heap{
    //堆较为重要的几个函数
    //上滤、下滤、插入、删除、堆排序
    //堆 这部分内容要重点掌握
    public int[] heap;
    public int currentSize;
    public int maxHeapSize;
    //构造函数
    public MinHeap(int maxHeapSize){
        //创建一个最小堆
        //heap数组存放堆中的数据
        this.heap=new int[maxHeapSize];
        this.currentSize=0;
        this.maxHeapSize=maxHeapSize;
    }
    //最小堆的下滤算法
    //复杂度是O(N)
    public void siftDown(int start,int m){
        //目的:从节点start开始到m为止，自上向下比较，如果子女的值小于父节点的值，则小关键码上浮,此时还要继续向下层比较
        //将这样一个子树调整成最小堆
        //说明，数组从0开始计数，所以如果根节点的下标是i，那么根节点的左子女的下标是2*i+1,右子女的下标是2*i+2
        int i=start,j=2*i+1;
        //根节点的值
        int temp=heap[i];
        while (j<=m){
            if(j<m && heap[j]>heap[j+1]){
                //指向两个子女中的较小的那个
                j++;
            }
            //如果根节点比较小的子女要小，那么直接跳出循环，因为这个已经是一个最小堆了
            //注意，这边一直比的是temp的值较小子女值的大小，因为我最后要找到最开始的根的值要放在哪里
            if(temp<heap[j]){
                break;
            } else {
                //把根节点调成较小的那个
                heap[i]=heap[j];
                //此时根变成较小的那个子女节点
                i=j;
                //继续深入到下一个左子女
                j=2*j+1;
            }
            //最开始的那个根的值要放到合适的地方
            heap[i]=temp;
        }
    }
    //上滤算法复杂度是O(NlogN)
    //一般不怎么使用
    public void siftUp(int start){
        //上滤操作主要用于堆的插入
        //思想：从节点start开始一直上滤到节点0(树根)为止，自下而上地进行比较，如果子女的节点的值小于父节点的值
        //则相互交换，这样将集合重新调整成最小堆
        int j=start,i=(j-1)/2;
        //注意，一开始的j指向一个子女节点，这样计算下来的i指向根节点(注意，使用(j-1)/2，不论j一开始指向的是左子节点还是右子节点，算下来都是父节点的下标值)
        int temp=heap[j];
        //沿着父节点的路径回溯，一直到达树根节点
        while (j>0){
            if(heap[i]<temp){
                break;
            }else {
                //如果根节点比子女节点大
                //将根节点拉下来
                heap[j]=heap[i];
                j=i;
                i=(i-1)/2;
            }
        }
        heap[j]=temp;//把一开始的叶子节点的值放到最后合适的地方
    }

    //堆的插入操作
    //将key值插入到堆中，保证堆还是一个最小堆
    public boolean Insert(int key){
        if(currentSize==maxHeapSize){
            System.out.println("堆满了！！");
            return false;
        }
        //先把这个值放到堆数组中，然后调用
        heap[currentSize]=key;
        siftUp(currentSize);
        currentSize++;
        return true;
    }
    //最小堆的删除算法
    //从最小堆删除具有最小关键码记录的操作是将最小堆的堆顶元素，即数组的0号元素删除，把这个元素取走之后，一般用堆的最后一个节点填补取走的元素，并将堆的实际元素个数-1
    //但是这样可能会破坏最小堆的结构，需要使用下滤算法向下调整成最小堆
    /**
     *
     * @param
     * @return 删除的最小的元素
     */
    public int Remove(){
        //如果堆已经是空了
        if(currentSize==0){
            System.out.println("堆空，删除操作无法进行！");
        }
        int key=heap[0];
        heap[0]=heap[currentSize-1];
        currentSize--;
        //自上而下逐步调整成最小堆
        siftDown(0,currentSize-1);
        return key;
    }

    /**
     * 参数传递一个数组，等待堆排序
     * @param heap 待排序的数组
     * @return 排序后的数组
     */
    public int[] HeapSort(int @NotNull [] heap){
        //对于最小堆，排下来应该是从大到小的顺序
        //思路：由于堆是一个最小堆，所以每次将堆顶元素与堆尾元素交换，然后再将0~currentSize-2(注意数组下标从0开始)这个被破环的堆使用下滤调整成最小堆接着处理

        //第一步，要将数组变成一个堆
        int len=heap.length;
        //首先得到第一个非叶节点
        int beginIndex=(len-1)/2;
        for(int i=beginIndex;i>=0;i--){
            siftDown(i,len-1);
        }
        //先把建立的最小堆给打印出来
        System.out.println(Arrays.toString(heap));
        //堆化之后开始排序，每次都是堆尾元素与堆首元素交换，然后再把前面的减堆
        for(int i=len-1;i>0;i--){
            swap(heap,0,i);
            siftDown(0,i-1);
        }
        return heap;
    }
    //交换数组两个位置的值
    private void swap(int[] heap,int i,int j){
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        MinHeap minHeap=new MinHeap(n);
        int len= minHeap.maxHeapSize;
        for(int i=0;i<len;i++){
            minHeap.heap[i]=scanner.nextInt();
        }
        System.out.println(Arrays.toString(minHeap.HeapSort(minHeap.heap)));
    }
}
