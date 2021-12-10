package DemoInClass.DemoInClass1126;
public class BinarySearchTree {
    //二叉搜索树或者是一棵空树，或者是一棵有下列性质的树
    //1.每个节点都有一个作为搜索依据的关键码
    //2.左子树(如果存在)的关键码都小于根节点的关键码
    //3.右子树(如果存在)的关键码都大于根节点的关键码
    //对于一棵二叉搜索树进行中序遍历，关键码从小到大排列

    /**
     * 二叉查找树的搜索
     * 使用递归
     * @param x 需要查找的值
     * @param root 根节点
     * @return 包含x值的节点
     */
    public static BSTNode Search(int x,BSTNode root){
        if(root==null){
            return null;
        }else if(x< root.data){
            return Search(x,root.left);
        }else if(x> root.data){
            return Search(x,root.right);
        }else {
            return root;
        }
    }
    /**
     * 向插入里插入
     * @param x 插入的值
     * @param root 根节点
     * @return 是否插入成功
     */
    public static boolean Insert(int x,BSTNode root){
        if(root==null){
            root=new BSTNode(x,null,null);
            return true;
        }else if(x<root.data){
            return Insert(x,root.left);
        }else if(x>root.data){
            return Insert(x,root.right);
        }else {
            return false;
        }
    }
    public static boolean Remove(int x,BSTNode root){
        BSTNode temp;
        if(root!=null){
            if(x< root.data){
                return Remove(x,root.left);
            }else if(x>root.data){
                return Remove(x,root.right);
            }else if(root.left!=null && root.right!=null){
                //如果要删的这个值正好是当前节点
                //如果当前节点左右节点都不为空
                temp=root.right;
                //寻找右子树的最小的节点
                while (temp.left!=null){
                    temp=temp.left;
                }
                //将当前节点的data替换成右子树的最小值
                root.data= temp.data;
                return Remove(root.data,root.right);
            }else {
                //如果当前节点只有左节点或者右节点
                if(root.left==null){
                    root=root.right;
                }else {
                    root=root.left;
                }
            }
        }
        return false;
    }
}
//二叉搜索树的节点类
class BSTNode{
    int data;
    BSTNode left;
    BSTNode right;
    BSTNode(int data,BSTNode left,BSTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}


