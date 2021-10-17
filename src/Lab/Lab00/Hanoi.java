package Lab.Lab00;

public class Hanoi {
    /**
     *汉诺塔问题：
     * 有三根杆子A，B，C。A杆上有 n 个 (n>1) 穿孔圆盘，盘的尺寸由上到下依次变大。要求按下列规则将所有圆盘移至 C杆：
     * (1)每次只能移动一个圆盘；
     * (2)大盘不能叠在小盘上面。
     * Q1:最少移动次数
     * Q2:移动策略
     */
    public static void main(String[] args) {
        int n = 4;
        System.out.println(f(n));
        hanoi(n, 'A', 'B', 'C');
    }

    // 解决第一个问题
    public static int f(int n) {
        if (n == 1) return 1;
        return 2 * f(n - 1) + 1;
    }

    // 解决第二个问题
    public static void hanoi(int n, char begin, char middle, char end) {
        if (n == 1) {
            System.out.println(begin + " --> " + end);
            return ; // 必须要有返回，结束递归
        }
        //上面n-1个圆盘利用柱C移动到B
        hanoi(n - 1, begin, end, middle);
        //最底下的那个最大的圆盘直接从A到C
        System.out.println(begin + " --> " + end);
        //柱B上面的n-1个通过A到C
        hanoi(n - 1, middle, begin, end);
    }
}
