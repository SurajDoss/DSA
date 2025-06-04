import AVLTree.AVLTree;
import BinaryTrees.Tree;
import Heaps.Heap;
import Heaps.MaxHeap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.print("DSA workarounds\n");

        //Test the tree DS
//        testTree();
//        testAVLTree();
//        testHeap();
        testHeapify();
    }

    private static void testTree(){
        Tree tree = new Tree();

        tree.insert(10);
        tree.insert(1);
        tree.insert(11);
        tree.insert(2);
        tree.insert(12);
        tree.insert(3);
        System.out.println(tree.find(220));

        System.out.println("\n");
        tree.preOderTraversal();
        System.out.println("\n");
        tree.inOderTraversal();
        System.out.println("\n");
        tree.postOderTraversal();

        System.out.println("\n");
        System.out.println(tree.height());


        System.out.println("\n");
        System.out.println(tree.min());

        Tree tree1 = new Tree();

        tree1.insert(10);

        tree1.insert(2);
        tree1.insert(12);
        tree1.insert(3);

        System.out.println("\n");
        System.out.println(tree.equals(tree1));


    }

    private static void testAVLTree(){
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(30);
        tree.insert(20);
        System.out.println(tree);

    }

    private static void testHeap(){
        Heap heap = new Heap();

        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);

        heap.remove();
    }

    private static void testHeapify(){
        int[] numbers = {5, 3, 8, 4, 1, 2};
        MaxHeap.heapify(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}