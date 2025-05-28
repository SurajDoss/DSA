package AVLTree;

import BinaryTrees.Tree;

public class AVLTree {

    private class AVLNode {
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int height;
        private int balanceFactor;

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
            rootNode = insert(rootNode, node );
        }

    }

    public int height( ){
        return height(rootNode);
    }

    private int height( AVLNode node ){
        if(node == null)
            return -1;

        if(isLeaf(node))
            return 0;

        return 1 + Math.max(height(rootNode.rightChild) , height(rootNode.leftChild));
    }

    private boolean isLeaf(AVLNode root){
        return root.leftChild == null && root.rightChild == null;
    }

    private AVLNode insert(AVLNode currentNode, AVLNode insertingNode ){
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

        currentNode.height = Math.max( calculatHeight(currentNode.leftChild), calculatHeight(currentNode.rightChild)) + 1;

        currentNode.balanceFactor = balanceFactor(currentNode);

        return balance( currentNode);
    }

    private AVLNode balance(AVLNode currentNode){
        if(currentNode.balanceFactor > 1 ){
            System.out.println("Left is Heavy");
            if(balanceFactor(currentNode.leftChild) < 0)
                currentNode.leftChild = rotateLeft(currentNode.leftChild); // System.out.println("Left Rotation "+ currentNode.leftChild.value);
            return rotateRight(currentNode); //System.out.println("Right Rotation " + currentNode.value);
        }else if( currentNode.balanceFactor < -1){
            System.out.println("Right is Heavy");
            if(balanceFactor(currentNode.rightChild) > 0 )
                currentNode.rightChild = rotateRight(currentNode.rightChild);// System.out.println("Right Rotation " + currentNode.rightChild.value);
            return rotateLeft(currentNode); //System.out.println("Left Rotation " + currentNode.value);
        }

        return currentNode;
    }

    private int balanceFactor(AVLNode node){
        return node == null ? 0 : calculatHeight(node.leftChild) - calculatHeight(node.rightChild);
    }

    private int calculatHeight(AVLNode node){
        return (node != null) ? node.height : -1;
    }

    private AVLNode rotateRight(AVLNode node){
        AVLNode newAVLNode = node.leftChild;

        node.leftChild = newAVLNode.rightChild;
        newAVLNode.rightChild = node;

        setHeight(node);
        setHeight(newAVLNode);
        return newAVLNode;
    }

    private AVLNode rotateLeft(AVLNode node){
        AVLNode newRoot = node.rightChild;

        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;

        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }
    private void setHeight(AVLNode node){
        node.height = Math.max( height(node.leftChild), height(node.rightChild))+1;
    }
}
