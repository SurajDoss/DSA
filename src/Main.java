import BinaryTrees.Tree;

public class Main {
    public static void main(String[] args) {
        System.out.print("DSA workarounds\n");

        //Test the tree DS
        testTree();
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
    }
}