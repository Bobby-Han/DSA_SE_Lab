package DemoInClass.DemoInClass0928;
public class MaxSubSequence {
    /**
     * 求最大子序和
     * 使用分治法加递归(可以将复杂度缩减到O(NlogN))
     * @param array the array
     * @return maxSumOfSubsequence
     */
    public static int findMaxSubSequence(int[] array,int low,int high){
        int maxRes=0;
        if(low==high){
            return array[0];
        }
        if(low>high){
            return 0;
        }
        int mid=(low+high)/2;
        int MaxSubSequenceInLeft=findMaxSubSequence(array,low,mid);
        int MaxSubSequenceInRight=findMaxSubSequence(array,mid+1,high);
        int maxLeftBorder=0;
        int maxRightBorder=0;
        int leftBorderSum=0;
        int rightBorderSum=0;
        for(int i=mid;i>=low;i--){
            leftBorderSum+=array[i];
            if(leftBorderSum>maxLeftBorder){
                maxLeftBorder=leftBorderSum;
            }
        }
        for(int i=mid+1;i<=high;i++){
            rightBorderSum+=array[i];
            if(rightBorderSum>maxRightBorder){
                maxRightBorder=rightBorderSum;
            }
        }
        return Math.max(Math.max(MaxSubSequenceInLeft,MaxSubSequenceInRight),maxLeftBorder+maxRightBorder);
    }
}
