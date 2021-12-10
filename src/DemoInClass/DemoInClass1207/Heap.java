package DemoInClass.DemoInClass1207;
public interface Heap {
    //比较重要的方法
    //上滤、下滤、插入、删除、堆排序
    public abstract void siftDown(int start, int m);
    public abstract void siftUp(int start);
    public abstract boolean Insert(int key);
    public abstract int Remove();
    public abstract int[] HeapSort(int[] heap);
}
