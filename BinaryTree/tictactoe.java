import java.util.LinkedList;

public class BinaryTree {
    public static class Node {
        Node left;
        Node right;
        int data;


        public Node(int data) {
            this.data = data;
            left=null;
            right=null;
        }
    }
    static int rootindex;
    Node root;
    int height;

    public BinaryTree(Node root) {
        this.root = root;
    }
    public static void printInorderutil(Node node)
    {
        if (node == null) {
            return;
        }
        printInorderutil(node.left);
        System.out.print(node.data + " ");
        printInorderutil(node.right);
    }
    public static void printInorder(Node node){
        printInorderutil(node);
        System.out.println("");
    }
    public static Node maketreefromtaverse(int[] inorder, int[] preorder, int low, int high){
        if(rootindex>=preorder.length){
            return null;
        }

        int index=-1;
        for(int i=0;i<=high;i++){
            if(inorder[i]==preorder[rootindex]){
                index=i;
            }
        }
        if(index==-1){
            return null;
        }
        Node root=new Node(inorder[index]);
        rootindex++;
        root.left=maketreefromtaverse(inorder,preorder,low,index-1);
        root.right=maketreefromtaverse(inorder,preorder,index+1,high);

        return root;

    }
    public static int getheight(Node root){
        if(root==null){
            return 0;
        }
        int leftheight=getheight(root.left)+1;
        int rightheight=getheight(root.right)+1;

        return Math.max(leftheight,rightheight);
    }
    public static int calcDiameter(Node root){
        if(root==null){
            return 0;
        }
        int leftheight=getheight(root.left);
        int rightheight=getheight(root.right);

        int leftdiameter=calcDiameter(root.left);
        int rightdiameter=calcDiameter(root.right);

        return Math.max(leftheight+rightheight+1,Math.max(leftdiameter,rightdiameter));
    }

    public static int sumreplacement(Node root){
        if(root==null){
            return 0;
        }
        int leftsum=sumreplacement(root.left);
        int rightsum=sumreplacement(root.right);
        int totalsum=leftsum+rightsum+root.data;
        return totalsum;
    }
    public static Node mirrortree(Node root){
        if(root==null){
            return null;
        }
        Node node=new Node(root.data);
        node.left=mirrortree(root.right);
        node.right=mirrortree(root.left);

        return node;
    }
    public static boolean isbalanced(Node root, Height height){

        if(root==null){
            height.h=0;
            return true;
        }
        Height leftheight=new Height();
        Height rightheight=new Height();
        boolean left= isbalanced(root.left, leftheight);
        if(left==false){
            return false;
        }

        boolean right=isbalanced(root.right, rightheight);

        if(right==false){
            return false;
        }
        height.h=(Math.max(leftheight.h,rightheight.h))+1;

        if((Math.abs(leftheight.h-rightheight.h))>1){
            return false;
        }
        else {
            return true;
        }

    }
    public static void printlevelorder(Node root){
        int count=0;
        LinkedList<Node> queue=new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        while(!queue.isEmpty()){
            Node node=queue.removeFirst();

            if(node==null){
                if(queue.isEmpty()){
                    break;
                }
                queue.addLast(null);
                System.out.println("level"+ ": " +count);
                count++;
                continue;
            }
            System.out.print(node.data+" ");
            if(node.left!=null){
                queue.addLast(node.left);
            }
            if(node.right!=null) {
                queue.addLast(node.right);
            }

        }

        System.out.print("level"+": " +count++);
        System.out.println("");
    }
    public static void printpreorderutil(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        printpreorderutil(root.left);
        printpreorderutil(root.right);
    }

    public static void printpreorder(Node root){
        printpreorderutil(root);
        System.out.println("");
    }