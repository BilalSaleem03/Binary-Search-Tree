public class BTS_delete {
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

    //delete

    public static Node delete(Node root , int val)
    {
        if(root.data>val)
        {
            root.left = delete(root.left , val);
        }
        else if(root.data< val)
        {
            root.right = delete(root.right , val);
        }
        else //found
        {
            //case 1
            if(root.left == null && root.right == null)
            {
                return null;
            }
            //case 2
            if(root.left == null)
            {
                return root.right;
            }
            if(root.right == null)
            {
                return root.left;
            }
            //case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right , IS.data);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root)
    {
        while(root.left != null)
        {
            root = root.left;
        }
        return root;
    }

    public static void main(String [] args)
    {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int i = 0 ; i<values.length;i++)
        {
            root = insert(root , values[i]);
        }
        inorder(root);
        System.out.println();
        //System.out.println(search(root , 7));
        delete(root , 5);
        inorder(root);
    }
}
