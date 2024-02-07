public class BTS_search {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root , int val)
    {
        if(root == null)
        {
            root = new Node(val);
            return root;
        }
        if(root.data > val)
        {
            root.left = insert(root.left , val);
        }
        else
        {
            root.right = insert(root.right , val);
        }
        return root;
    }

    public static void inorder(Node root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root , int find)
    {
        
        if(root == null)
        {
            return false;
        }
        if(root.data > find)
        {
            return search(root.left , find);
        }
        else if(root.data == find)
        {
            return true;
        }
        else
        {
            return search(root.right , find);
        }
        //return false;
    }

    public static void main(String [] args)
    {
        int values[] = {5,1,3,4,11,10,2,8,9,12};
        Node root = null;
        for(int i = 0 ; i<values.length;i++)
        {
            root = insert(root , values[i]);
        }
        inorder(root);
        System.out.println();
        System.out.println(search(root , 7));
    }
}
