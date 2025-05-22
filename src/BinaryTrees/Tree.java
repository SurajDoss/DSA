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

}
