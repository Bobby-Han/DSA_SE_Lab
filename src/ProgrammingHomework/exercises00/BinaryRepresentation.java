package ProgrammingHomework.exercises00;

import java.util.Scanner;

public class BinaryRepresentation {
    public static String toBinary(int n){
        return Integer.toBinaryString(n);
    }
    public static int count_1(int n){
        String str1=toBinary(n);
        if(str1.equals("1")){
            return 1;
        }else if (str1.equals("0")){
            return 0;
        }else{
            if(n%2==0){
                return count_1(n/2);
            }else {
                return 1+count_1(n/2);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int res=count_1(n);
        System.out.println(res);
        System.out.println(Integer.toBinaryString(89));
    }
}
