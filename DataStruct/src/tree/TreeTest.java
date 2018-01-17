package tree;

/**
 * Created by gavin on 2018/1/16.
 */
public class TreeTest {

    public static void main(String[] args) {

        //binarayTreeTest();

        searchBinarayTreeTest();

    }


    private static void searchBinarayTreeTest(){


        int [] arrays={1,34,56,78,23,43,21,44,33};

        SearchBinarayTree tree=new SearchBinarayTree();

        for (int array : arrays) {
            tree.put(array);
        }

        tree.midOrderTraverse(tree.getRoot());

        System.out.println("");

        SearchBinarayTree.TreeNode treeNode = tree.searchNode(56);

        tree.deleteNote(treeNode);

        tree.midOrderTraverse(tree.getRoot());


    }

    private static void binarayTreeTest() {
        BinarayTree tree=new BinarayTree();

        tree.preOrderTraverse(tree.root);
        // tree.midOrderTraverse(tree.root);
        // tree.postOrderTraverse(tree.root);


        tree.preOrderTraverseStack(tree.root);
    }


}
