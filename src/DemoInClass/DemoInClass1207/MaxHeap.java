package DemoInClass.DemoInClass1207;

import java.util.Arrays;
import java.util.Scanner;

public class MaxHeap implements Heap{
    public int[] heap;
    public int currentSize;
    public int maxHeapSize;
    public MaxHeap(int maxHeapSize){
        this.heap=new int[maxHeapSize];
        this.currentSize=0;
        this.maxHeapSize=maxHeapSize;
    }
    //
    public void siftDown(int start,int m){
        //目的:从节点start开始到m为止，自上向下比较，如果子女的值大于父节点的值，则大关键码上浮,此时还要继续向下层比较
        //将这样一个子树调整成最大堆
        //说明，数组从0开始计数，所以如果根节点的下标是i，那么根节点的左子女的下标是2*i+1,右子女的下标是2*i+2
        int i=start,j=2*i+1;
        //根节点的值
        int temp=heap[i];
        while (j<=m){
            if(j<m && heap[j]<heap[j+1]){
                //指向两个子女中的较大的那个
                j++;
            }
            //如果根节点比较大的子女要大，那么直接跳出循环，因为这个已经是一个最大堆了
            //注意，这边一直比的是temp的值较小子女值的大小，因为我最后要找到最开始的根的值要放在哪里
            if(temp>heap[j]){
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
    public void siftUp(int start){
        //上滤操作主要用于堆的插入
        //思想：从节点start开始一直上滤到节点0(树根)为止，自下而上地进行比较，如果子女的节点的值大于父节点的值
        //则相互交换，这样将集合重新调整成最大堆
        int j=start,i=(j-1)/2;
        //注意，一开始的j指向一个子女节点，这样计算下来的i指向根节点(注意，使用(j-1)/2，不论j一开始指向的是左子节点还是右子节点，算下来都是父节点的下标值)
        int temp=heap[j];
        //沿着父节点的路径回溯，一直到达树根节点
        while (j>0){
            if(heap[i]>temp){
                break;
            }else {
                //如果根节点比子女节点小
                //将根节点拉下来
                heap[j]=heap[i];
                j=i;
                i=(i-1)/2;
            }
        }
        heap[j]=temp;//把一开始的叶子节点的值放到最后合适的地方
    }
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
    public int[] HeapSort(int[] heap){
        //首先要建堆
        int len=heap.length;
        //首先得到第一个非叶节点
        int beginIndex=(len-1)/2;
        for(int i=beginIndex;i>=0;i--){
            siftDown(i,len-1);
        }
        //先把建立的最大堆给打印出来
        System.out.println(Arrays.toString(heap));
        //堆化之后开始排序，每次都是堆尾元素与堆首元素交换，然后再把前面的减堆
        for(int i=len-1;i>0;i--){
            swap(heap,0,i);
            siftDown(0,i-1);
        }
        return heap;
    }
    private void swap(int[] heap,int i,int j){
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        MaxHeap maxHeap=new MaxHeap(n);
        for(int i=0;i<n;i++){
            maxHeap.heap[i]=scanner.nextInt();
        }
        System.out.println(Arrays.toString(maxHeap.HeapSort(maxHeap.heap)));
    }



























}
