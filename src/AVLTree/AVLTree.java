package AVLTree;

import BinaryTrees.Tree;

public class AVLTree {

    private class AVLNode {
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int height;

        AVLNode(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value ::" + value;
        }
    }

    private AVLNode rootNode;
    private int height;

    public void insert(int value){
        AVLNode node = new AVLNode(value);

        if(rootNode == null){
            rootNode = node;
        }else{
            insert(rootNode, node );
        }

    }

    public int height( ){
        return height(rootNode);
    }

    private int height( AVLNode node ){
        if(rootNode == null)
            return -1;

        if(isLeaf(node))
            return 0;

        return 1 + Math.max(height(rootNode.rightChild) , height(rootNode.leftChild));
    }

    private boolean isLeaf(AVLNode root){
        return root.leftChild == null && root.rightChild == null;
    }

    private void insert(AVLNode currentNode, AVLNode insertingNode ){
        if (insertingNode.value < currentNode.value) {
            if (currentNode.leftChild == null) {
                currentNode.leftChild = insertingNode;
            }else {
                insert(currentNode.leftChild, insertingNode);
            }
        } else {
            if (currentNode.rightChild == null) {
                currentNode.rightChild = insertingNode;
            }else{
                insert(currentNode.rightChild, insertingNode);
            }
        }

        currentNode.height = Math.max(calculatHeight(currentNode.leftChild), calculatHeight(currentNode.rightChild)) + 1;
    }

    private int calculatHeight(AVLNode node){
        return (node != null) ? node.height : -1;
    }
}
