package DemoInClass.DemoInClass1105;
import java.util.HashMap;
import java.util.Map;


public class PostAndInOrderToBuildTree {
    private Map<Integer, Integer>index;
    public TreeNode my_buildTree(int[] inorder,int[] postorder,int inorder_left,int inorder_right,int postorder_left,int postorder_right){
        //递归基
        if(inorder_left>inorder_right){
            return null;
        }
        int postorder_root_index=postorder_right;//后序遍历的最后一个元素必然是整个二叉树的根节点
        int inorder_root_index=index.get(postorder[postorder_root_index]);//得到中序遍历中整个二叉树的根节点的下标
        int leftTreeNodeNum=inorder_root_index-inorder_left;//得到左子树节点的个数
        TreeNode root=new TreeNode(inorder[inorder_root_index]);//建立树根


        root.left=my_buildTree(inorder,postorder,inorder_left,inorder_left+leftTreeNodeNum-1,postorder_left,postorder_left+leftTreeNodeNum-1);
        root.right=my_buildTree(inorder,postorder,inorder_left+leftTreeNodeNum+1,inorder_right,postorder_left+leftTreeNodeNum,postorder_right-1);
        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index=new HashMap<>();
        int len=inorder.length;
        for(int i=0;i<len;i++)
        {
            index.put(inorder[i],i);
        }
        return my_buildTree(inorder,postorder,0,len-1,0,len-1);
    }

    public static void main(String[] args) {
        int[] inorder={9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        PostAndInOrderToBuildTree postAndInOrderToBuildTree =new PostAndInOrderToBuildTree();
        TreeNode root= postAndInOrderToBuildTree.buildTree(inorder,postorder);
        System.out.println("yes");
    }






}
