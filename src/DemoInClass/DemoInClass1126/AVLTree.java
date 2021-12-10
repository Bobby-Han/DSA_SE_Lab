package DemoInClass.DemoInClass1126;

import java.util.Stack;

public class AVLTree {
    //高度平衡的二叉搜索树
    //提高二叉搜索树的效率，减少树的平均搜索长度
    //一些概念，平衡因子：指右子树的高度-左子树的高度
    //对于AVL树，bf的可能取值只有-1、0、1

    /**
     * 向左单旋转
     * @param ptr 当前节点
     */
    public static void RotateLeft(AVLTreeNode ptr){
        AVLTreeNode subL=ptr;
        ptr=ptr.right;
        //先调一下subL的右节点
        subL.right=ptr.left;
        //再调一下ptr的左节点
        ptr.left=subL;
        //更新平衡因子
        ptr.bf=subL.bf=0;
    }

    /**
     * 右单旋
     * @param ptr 当前节点指针
     */
    public static void RotateRight(AVLTreeNode ptr){
        AVLTreeNode subR=ptr;
        ptr=ptr.left;
        subR.left=ptr.right;
        ptr.right=subR;
        subR.bf=ptr.bf=0;
    }

    /**
     * 先左后右双旋转
     * @param ptr 当前节点
     */
    public static void RotateLR(AVLTreeNode ptr){
        AVLTreeNode subR=ptr;
        AVLTreeNode subL=subR.left;
        ptr=subL.right;
        subL.right=ptr.left;
        ptr.left=subL;
        if(ptr.bf<=0){
            subL.bf=0;
        }else {
            subL.bf=-1;
        }
        subR.left=ptr.right;
        ptr.right=subR;
        if(ptr.bf==-1){
            subR.bf=-1;
        }else {
            subR.bf=0;
        }
        ptr.bf=0;
    }

    /**
     * 先右旋再左旋
     * @param ptr 当前节点
     */
    public static void RotateRL(AVLTreeNode ptr){
        AVLTreeNode subL=ptr;
        AVLTreeNode subR=subL.right;
        ptr=subR.left;
        subR.left=ptr.right;
        ptr.right=subR;
        if(ptr.bf>=0){
            subR.bf=0;
        }else {
            subR.bf=-1;
        }
        subL.right=ptr.left;
        ptr.left=subL;
        if(ptr.bf==1){
            subL.bf=-1;
        }else {
            subL.bf=0;
        }
        ptr.bf=0;
    }
    //AVL树的插入和删除操作
    //过程比较复杂
    //需要深入理解掌握

    /**
     * 将一个新节点作为叶节点插入并且逐层修改各个节点的平衡因子
     * 再程序中，使用一个栈记录从跟开始逐层向下寻找插入位置时所经过的路径，用于重新平衡化时从下向上检查该路径上各个节点的平衡因子
     * @param ptr 当前节点
     * @return 是否插入成功
     */
    public static boolean Insert(AVLTreeNode ptr,int x){
        AVLTreeNode pr=null;
        AVLTreeNode p=ptr;
        AVLTreeNode q;
        int d;
        Stack<AVLTreeNode> st=new Stack<>();
        //使用一个栈来保存路径
        while (p!=null){
            if(x==p.data){
                return false;
            }
            pr=p;
            st.push(pr);
            if(x<p.data){
                p=p.left;
            }else {
                p=p.right;
            }
        }
        p=new AVLTreeNode(x,0,null,null);
        if(ptr==null){
            ptr=p;
            return true;
        }
        if(x<pr.data){
            pr.left=p;
        }else{
            pr.right=p;
        }
        while (!st.isEmpty()){
            pr=st.peek();
            st.pop();
            if(p==pr.left){
                pr.bf--;
            }else {
                pr.bf++;
            }
            if(pr.bf==0){
                break;//平衡退出
            }
            if(pr.bf==1 || pr.bf==-1){
                p=pr;//对应|br|==1的情况
            }else{
                //|bf|=2的情况
                d= (pr.bf < 0)?-1:1;//区别单双旋
                if(p.bf==d){
                    //两节点平衡因子同号，单旋
                    if(d==-1){
                        RotateRight(pr);
                    }else {
                        RotateLeft(pr);
                    }
                }else {
                    if(d==-1){
                        RotateLR(pr);
                    }else {
                        RotateRL(pr);
                    }
                }
                break;
            }
        }
        if(st.isEmpty()){
            ptr=pr;
        }else {
            q=st.peek();
            if(q.data>pr.data){
                q.left=pr;
            }else {
                q.right=pr;
            }
        }
        return true;
    }
    //删除算法过于复杂
    //暂时不要求掌握
}
class AVLTreeNode{
    int data;
    int bf;//平衡因子
    AVLTreeNode left;
    AVLTreeNode right;
    AVLTreeNode(int data,int bf,AVLTreeNode left,AVLTreeNode right){
        this.data=data;
        this.left=left;
        this.right=right;
        this.bf=bf;
    }
}


