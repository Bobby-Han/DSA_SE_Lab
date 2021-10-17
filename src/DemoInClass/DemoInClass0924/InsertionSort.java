package DemoInClass.DemoInClass0924;

public class InsertionSort {
    public static int[] insertionSort(int[] array){
        int lengthOfArray=array.length;
        for(int i=1;i<lengthOfArray;i++){
            int currentValue=array[i];
            int j=i-1;
            while (j>=0 && array[j]>=currentValue){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=currentValue;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array={1,4,3,5,6};
        int[] afterSort=InsertionSort.insertionSort(array);
        for (int j : afterSort) {
            System.out.print(j + " ");
        }
    }








}
