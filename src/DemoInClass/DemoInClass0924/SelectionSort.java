package DemoInClass.DemoInClass0924;
public class SelectionSort {
    public static int IndexOfMinVal(int[] array,int low,int high){
        if(low==high){
            return low;
        }
        int minIndex=low;
        int possibleMinIndex=IndexOfMinVal(array,low+1,high);
        int possibleEle=array[possibleMinIndex];
        int result=array[low]<possibleEle? low:possibleMinIndex;
        return result;
    }
    public static void moveToFirst(int[] array,int low,int IndexOfMinVal){
        int temp=array[low];
        array[low]=array[IndexOfMinVal];
        array[IndexOfMinVal]=temp;
    }
    public static int[] selectionSort(int[] array){
        int lenOfArray=array.length;
        for(int i=0;i<lenOfArray;i++){
            int minIndex=IndexOfMinVal(array,i,lenOfArray-1);
            moveToFirst(array,i,minIndex);
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array={5,7,4,3,1};
        int[] result=selectionSort(array);
        for(int ele:result){
            System.out.print(ele+" ");
        }
    }
}
