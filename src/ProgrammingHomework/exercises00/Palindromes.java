package ProgrammingHomework.exercises00;

import java.util.Locale;

public class Palindromes {
    public static String parse(String ori){
        String res=ori.replaceAll("[\\W]","");
        String ans=res.toLowerCase(Locale.ROOT);
        return ans;
    }
    public static boolean isPalindrome(char[] target,int low,int high){
        if(low==high){
            return true;
        }
        if(low>high){
            return false;
        }
        if(target[low]!=target[high]){
            return false;
        }
        return isPalindrome(target,low+1,high-1);
    }
    public static void main(String[] args) {
        String s1="Madam, I'm Adam";
        String res1=parse(s1);
        char[] res2=res1.toCharArray();
        if(isPalindrome(res2,0, res2.length-1)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
