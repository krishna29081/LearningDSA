class BinaryTreeNode{

    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }
}


public class BinarySearchTree {

    static BinaryTreeNode generateBinarySearchTree(BinaryTreeNode bst, int val) {
        if (bst == null)
            return new BinaryTreeNode(val);
        if(bst.val > val) {
            bst.left = generateBinarySearchTree(bst.left, val);
//            System.out.println(bst.val);
        }else {
            bst.right = generateBinarySearchTree(bst.right,val);
//            System.out.println(bst.val);
        }
        return bst;
    }


    static void inOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }


    static boolean searchKey(BinaryTreeNode root, int key) {
        if(root == null) {
            return false;
        }

        if(root.val == key){
            return true;
        }
        if(key>root.val){
            searchKey(root.right,key);
        }else {
            searchKey(root.left,key);
        }

        return false;
    }

    static  BinaryTreeNode delete(BinaryTreeNode root,int key) {
        if(key>root.val) {
            delete(root.right,key);
        } else if (key< root.val) {
            delete(root.left,key);
        }else {
            // case 1  if there is no child
            if(root.right == null && root.left == null) {
                return null;
            }
            // case 2 if there is one child
            if(root.right != null) {
                return root.right;
            }else if(root.left != null) {
                return root.left;
            }
            // case 3 : if there are both child
            BinaryTreeNode nextNode = inOrderSuccessor(root.right);
            root.val = nextNode.val;
            root.right = delete(root.right, nextNode.val);
        }
        return  root;
    }

    static BinaryTreeNode inOrderSuccessor(BinaryTreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return  root;
    }


    public static void main(String[] args) {
        int[] nodes = {17,1,3,10,8,11};
        BinaryTreeNode node = null;
        for (int i = 0; i < nodes.length ; i++) {
            node = generateBinarySearchTree(node,nodes[i]);
        }
        System.out.println("Inorder Traversal");
        inOrder(node);
        System.out.println();
//        System.out.println("Search Key");
//        System.out.println(searchKey(node,0));
        System.out.println("Delete Key");
        delete(node,17);
        inOrder(node);

    }
}
