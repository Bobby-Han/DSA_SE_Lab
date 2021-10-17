package DemoInClass.DemoInClass0924;

public class RankSort {
    public static int[] rank=new int[10010];
    public static void CalculateRank(int[] array){
        int lenOfArray=array.length;
        for(int i=1;i<lenOfArray;i++){
            for(int j=0;j<i;j++){
                if(array[j]<array[i]){
                    rank[i]++;
                }else {
                    rank[j]++;
                }
            }
        }
        //对rank的理解：r[i]表示比array[i]小的数有几个
    }
    public static void swap(int[] array,int idx1,int idx2){
        int temp=array[idx1];
        array[idx1]=array[idx2];
        array[idx2]=temp;
    }
    public static int[] rankSort(int[] array){
        CalculateRank(array);
        for(int i=0;i<array.length;i++){
            while (rank[i]!=i){
                int temp=rank[i];
                swap(array,i,temp);//一定要注意对应的秩也要更改
                swap(rank,i,temp);
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array={1,6,4,5,3,7,9};
        int[] result=rankSort(array);
        for(int ele:result){
            System.out.print(ele+" ");
        }
    }
}
