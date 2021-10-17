package ProgrammingHomework.exercises00;

import java.util.ArrayList;

public class Permute {
    private static ArrayList<String> res=new ArrayList<>();
    public void permute(String str){
        permute(str.toCharArray(),0,str.toCharArray().length-1);
    }
    private void permute(char[] str,int low,int high){
        if(low>=high){
            res.add(new String(str));
            return;
        }
        for(int i=low;i<=high;i++){
            swap(str,low,i);
            permute(str,low+1,high);
            //要将串还原
            swap(str,low,i);
        }
    }
    private void swap(char[] str,int i,int j){
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }
}
