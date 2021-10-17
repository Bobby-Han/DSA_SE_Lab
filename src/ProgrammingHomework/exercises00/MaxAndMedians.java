package ProgrammingHomework.exercises00;

public class MaxAndMedians {
    public static int find_max(int[] nums,int low,int high){
        if(low==high){
            return nums[low];
        }
        if(low>high){
            return -1;
        }
        return Math.max(nums[low],find_max(nums,low+1,high));
    }
    public static double calculateMedians(int[] nums,int low,int high){
        if(low==high){
            return nums[low];
        }
        if(low>high){
            return -1;
        }
        return (nums[low]+(calculateMedians(nums,low+1,high)*(high-low)))/(high-low+1);
    }



    public static void main(String[] args) {
        int[] nums={1,4,3,8,9};
        System.out.println(find_max(nums,0,nums.length-1));
        System.out.println(calculateMedians(nums,0,nums.length-1));
    }
}
