import java.util.LinkedList;
import java.util.Queue;

public class ListInBinaryTree {

    private  static TreeNode buildTreeFromLvlOrderTraversal(int[] nodes,TreeNode root,int i, int n) {


        if(i<n) {
            if(nodes[i] == -1)
                { return new TreeNode(-1); }

            root = new TreeNode(nodes[i]);
        root.left = buildTreeFromLvlOrderTraversal(nodes,root.left,2*i + 1 , n);
        root.right = buildTreeFromLvlOrderTraversal(nodes,root.right,2*i + 2, n);}

    return root;
    }

    private static ListNode createList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        int i =1;
        while(i< arr.length) {
            ListNode node = new ListNode(arr[i]);
            curr.next = node;
            curr = node;
            i++;
        }
        return head;
    }

    static void preOrder(TreeNode root) {
        if(root == null)
            return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void levelOrder(TreeNode root){
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

    public static void main(String[] args) {
        int[] nodes = {1,4,4,-1,2,2,-1,1,-1,6,8,-1,-1,-1,-1,1,3};
        TreeNode root = new TreeNode(nodes[0]);
        TreeNode root1 = buildTreeFromLvlOrderTraversal(nodes,root,0,nodes.length);
        levelOrder(root1);
        int[] listNodes = {1,4,2,6};
        ListNode head = createList(listNodes);

        System.out.println(isSubPath(head,root));
    }

    private static boolean isSubPath(ListNode head, TreeNode root) {

        return false;
    }
}
