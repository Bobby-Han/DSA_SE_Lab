package DemoInClass.DemoInClass0924;

public class BinarySearch {
    //二分查找,返回要找数的index,不存在的时候返回-1
    //二分查找要求有序序列
    //时间复杂度O(logN)
    /**
     * 查找x的位置并返回，如果有多个x的位置，返回其左边界，如果没有，返回-1
     * @param array the original array
     * @param x the target value
     * @return leftmost index of x if it exists,else return -1
     */
    public static int binarySearchLeftMost(int[] array,int x){
        array=RankSort.rankSort(array);
        int low=0,high=array.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(x<=array[mid]){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        if(low>=array.length || array[low]!=x){
            return -1;
        }
        return low;
    }
    /**
     * 查找x的位置并返回，如果有多个x的位置，返回其右边界，如果没有，返回-1
     * @param array the original array
     * @param x rightmost index of x if it exists,else return -1
     * @return
     */
    public static int binarySearchRightMost(int[] array,int x){
        array=RankSort.rankSort(array);
        int low=0,high=array.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(x>=array[mid]){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        if(high<0 || array[high]!=x){
            return -1;
        }
        return high;
    }
}
