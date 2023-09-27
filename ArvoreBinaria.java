class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class ArvoreBinaria {
    Node root;

    public ArvoreBinaria() {
        root = null;
    }

    public void insert(int data) {
        root = insertData(root,data);
    }

    private Node insertData(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data <= root.data)
            root.left = insertData(root.left, data);
        else
            root.right = insertData(root.right, data);
        return root;
    }

    public void printTree() {
        preOrder(root);
    }

    public void preOrder(Node branch) {
        if(branch != null) {
            System.out.println(branch.data+"");
            preOrder(branch.left);
            preOrder(branch.right);
        }
    }
    public void removeH() {
        if (root != null) {
            Node parent = null;
            Node current = root;
            while (current.right != null) {
                parent = current;
                current = current.right;
            }
            if (parent != null) {
                parent.right = null;
            } else {
                root = null;
            }
        }
    }

    public void removeL() {
        if (root != null) {
            Node parent = null;
            Node current = root;
            while (current.left != null) {
                parent = current;
                current = current.left;
            }
            if (parent != null) {
                parent.left = null;
            } else {
                root = null;
            }
        }
    }

    public void removeN(int i) {
        root = removeN(root, i);
    }

    private Node removeN(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = removeN(root.left, key);
        } else if (key > root.data) {
            root.right = removeN(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);

            root.right = removeN(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

}


class Main{
    public static void main(String[] args) {
        ArvoreBinaria a = new ArvoreBinaria();

        a.insert(12);
        a.insert(4);
        a.insert(2);
        a.insert(8);
        a.insert(6);
        a.insert(16);
        a.insert(50);
        a.insert(4);

        a.removeH();

        a.removeL();

        a.removeN(6);

        a.printTree();
    }
}