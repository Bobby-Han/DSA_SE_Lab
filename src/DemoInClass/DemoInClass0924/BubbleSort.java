package DemoInClass.DemoInClass0924;

public class BubbleSort {
    public static void swap(int[] array,int idx1,int idx2){
        int temp=array[idx1];
        array[idx1]=array[idx2];
        array[idx2]=temp;
    }
    public static int[] bubbleSort(int[] array){
        int lenOfarray=array.length;
        for(int i=0;i<lenOfarray-1;i++){
            for(int j=i+1;j<lenOfarray;j++){
                if(array[j]<array[j-1]){
                    swap(array,j,j-1);
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array={1,4,3,2,5};
        int[] result=BubbleSort.bubbleSort(array);
        for(int i=0;i<result.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
