package DemoInClass.DemoInClass1022;

import java.util.Deque;
import java.util.LinkedList;

public class ParenthesisMatching {
    //括号匹配，使用栈来解题
    public static void PrintMatchPairs(String expression){
        Deque<Integer> s=new LinkedList<>();//使用Deque容器，比Stack容器更加方便一些
        int len=expression.length();
        for(int i=0;i<len;i++){
            if(expression.charAt(i)=='('){
                s.push(i);
            }else if(expression.charAt(i)==')'){
                if(!s.isEmpty()){
                    int top=s.peek();
                    System.out.println("第 "+(i+1)+" 个右括号与第"+(top+1)+"个左括号匹配成功！");
                    s.pop();
                }else {
                    System.out.println("第 "+(i+1)+" 个右括号匹配失败！");
                }
            }
        }
    }
    public static void main(String[] args) {
        String expression="(1+2)+((5+4-7)))";
        PrintMatchPairs(expression);
    }
}
