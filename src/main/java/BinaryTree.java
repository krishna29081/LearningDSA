import java.util.LinkedList;
import java.util.Queue;

//Definition for a binary tree node.
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
  }



public class BinaryTree{
    int index = -1;

    TreeNode buildTree(int[] nodes) {
        index++;
        if(nodes[index]==-1)
            return null;

        TreeNode node = new TreeNode(nodes[index]);
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    void preOrder(TreeNode root) {
        if(root == null)
            return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void postOrder(TreeNode root) {
        if(root== null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }


    void inOrder(TreeNode root){
        if(root==null)
            return ;

        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);

    }
    void levelOrder(TreeNode root){
        if(root==null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node == null){
                System.out.println();
                if(q.isEmpty()) {
                    break;
                }else{
                    q.add(null);
                }
            }else {
                System.out.print(node.val+ " ");
                if(node.left!= null)
                    q.add(node.left);
                if(node.right!= null)
                    q.add(node.right);
            }
        }
    }
    int countOfNodes(TreeNode root) {
        if(root == null)
            return 0;
        int leftCount = countOfNodes(root.left);
        int rightCount = countOfNodes(root.right);
        return leftCount + rightCount + 1;

    }

    int heightOfTree(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }
    static class TreeInfo{
        int ht;
        int diam;

        public TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    TreeInfo maxDiameterOfTree(TreeNode root){
        if(root == null)
            return new TreeInfo(0, 0);

        TreeInfo left = maxDiameterOfTree(root.left);
        TreeInfo right = maxDiameterOfTree(root.right);

        int myht = Math.max(left.ht,right.ht) +1;

        int diam1 =  left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht +1;

        int mydiam = Math.max(Math.max(diam1,diam2),diam3);

        return new TreeInfo(myht, mydiam);

    }



    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int[] nodes2 = {1,2,-1,-1,3,-1,-1};
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.buildTree(nodes2);
        System.out.println("\n"+"PRE ORDER");
        bt.preOrder(root);
        System.out.println("\n"+"POST ORDER");
        bt.postOrder(root);
        System.out.println("\n"+"INORDER ORDER");
        bt.inOrder(root);
        System.out.println("\n"+"LEVEL ORDER");
        bt.levelOrder(root);
        System.out.println("\n"+"COUNT OF NODES");
        System.out.println(bt.countOfNodes(root));
        System.out.println("\n"+"HEIGHT OF TREE");
        System.out.println(bt.heightOfTree(root));
        System.out.println("\n"+"Max Diameter OF TREE");
        System.out.println(bt.maxDiameterOfTree(root).diam);
    }

}
