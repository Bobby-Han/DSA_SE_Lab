package Lab.Lab00;

public class Arrangement {
    int[] a=new int[1000];
    public void range(int n,int r,int m){
        if(n<r){
            return;
        }
        if (r==0){
            for(int i=0;i<m;i++){
                System.out.printf("%d",a[i]);
            }
            System.out.println();
            return;
        }else {
            a[m]=n;
            //如果选了n,只要在剩下的n-1个当中选择r-1个
            range(n-1,r-1,m+1);
            //如果没有选n,那么在剩下的n-1中需要选择r个
            range(n-1,r,m);
        }
    }





















}
