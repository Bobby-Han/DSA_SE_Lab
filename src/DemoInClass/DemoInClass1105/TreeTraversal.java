package DemoInClass.DemoInClass1105;
import java.util.Deque;
import java.util.LinkedList;


//今天的课上讲解了树的四种遍历方式(先序、中序、后序、层次遍历)，使用JAVA实现
public class TreeTraversal {
    //使用递归的方法进行先序、中序、后序遍历
    //先序遍历(先打印根，再打印左子树，再打印右子树)
    public static void PreOrderTraversal(TreeNode root){
        if(root==null) {
            return;
        }
        System.out.print(root.ele+" ");
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }
    //后序遍历(先打印左子树，再打印右子树，最后再打印根)
    public static void PostOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        System.out.print(root.ele+" ");
    }
    //中序遍历(先打印左子树，再打印根，再打印右子树)
    public static void InOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        InOrderTraversal(root.left);
        System.out.print(root.ele+" ");
        InOrderTraversal(root.right);
    }
    public static void LevelOrderTraversal(TreeNode root){
        //使用队列来模拟
        Deque<TreeNode> helperDequeue=new LinkedList<>();//辅助队列
        helperDequeue.addLast(root);
        while (!helperDequeue.isEmpty()){
            TreeNode temp= helperDequeue.pollFirst();
            System.out.print(temp.ele+" ");
            if(temp.left!=null){
                helperDequeue.addLast(temp.left);
            }
            if(temp.right!=null){
                helperDequeue.addLast(temp.right);
            }
        }
    }
    //构建一棵树，使用递归的方法！
    public TreeNode buildTree(TreeNode root, int val){
        if(root==null){
            root=new TreeNode(val);
            return root;
        }
        if(val<=root.ele){
            root.left=buildTree(root.left,val);
        }else {
            root.right=buildTree(root.right,val);
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(8);
        TreeNode node9=new TreeNode(9);
        root.left=node2;
        root.right=node3;
        node2.left=node4;
        node3.left=node5;
        node3.right=node6;
        node5.right=node7;
        node6.left=node8;
        node6.right=node9;
        PreOrderTraversal(root);
        System.out.println();
        InOrderTraversal(root);
        System.out.println();
        PostOrderTraversal(root);
        System.out.println();
        LevelOrderTraversal(root);
    }
}
class TreeNode{
    int ele;
    TreeNode left;
    TreeNode right;
    TreeNode(int ele){
        this.ele=ele;
        this.left=null;
        this.right=null;
    }
}




