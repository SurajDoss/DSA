package BinaryTrees;

public class Tree {

    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString(){
            return "Node " + value;
        }
    }


    private Node rootNode;

    public void   insert(int value){
        var node = new Node(value);
        if(rootNode == null){
            rootNode = node;
            return;
        }

        var current = rootNode;

        while(true){
            if(value < current.value){
                if(current.leftChild == null){
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }else{
                if(current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find (int value){
        var current = rootNode;

        while( current != null){
            if(value < current.value){
                current = current.leftChild;
            }else if (value > current.value){
                current = current.rightChild;
            }else{
                return true;
            }
        }
        return false;
    }

    public void preOderTraversal(){
        preOderTraversal(rootNode);
    }

    private void preOderTraversal(Node node){
    if(node == null){
        return;
    }
        System.out.println(node.value);
        preOderTraversal(node.leftChild);
        preOderTraversal(node.rightChild);
    }


    public void inOderTraversal(){
        inOderTraversal(rootNode);
    }

    private void inOderTraversal(Node node){
        if(node == null) {
            return;
        }
        inOderTraversal(node.leftChild);
        System.out.println(node.value);
        inOderTraversal(node.rightChild);
    }

    public void postOderTraversal(){
        postOderTraversal(rootNode);
    }

    private void postOderTraversal(Node node){
        if(node == null) {
            return;
        }
        postOderTraversal(node.leftChild);
        postOderTraversal(node.rightChild);
        System.out.println(node.value);
    }

    public int height(){
        return height(  rootNode );
    }

    public int height( Node node ){
        if(node == null)
            return -1;

        if(isLeaf(node))
            return 0;
        return 1 + Math.max(height(node.rightChild) , height(node.leftChild));
    }

    private boolean isLeaf(Node root){
        return root.leftChild == null && root.rightChild == null;
    }

    //O(log n)
    public int min(){
        if(rootNode == null)
            throw new IllegalStateException();

        var current = rootNode;
        var last = current;
        while(current != null){
            last = current;
            current = current.leftChild;

        }

        return last.value;
//        return min(rootNode);
    }

    //O(N)
    private int min(Node root){
        if (root == null)
            return Integer.MAX_VALUE;

        if( isLeaf(root)){
            return root.value;
        }
        var leftChild = min(root.leftChild);
        var rightChild= min(root.rightChild);

        return  Math.min( Math.min(leftChild, rightChild), root.value);

    }

    public boolean equals(Tree other){
        if(other == null){
            return false;
        }
        return equals(rootNode, other.rootNode);
    }

    public boolean equals(Node first, Node second){
        if(first == null && second == null)
            return true;

        if(first != null && second != null){
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }

        return false;
    }
}
