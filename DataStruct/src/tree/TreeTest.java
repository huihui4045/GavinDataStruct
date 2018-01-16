package tree;

/**
 * Created by gavin on 2018/1/16.
 */
public class TreeTest {

    public static void main(String[] args) {

        BinarayTree tree=new BinarayTree();

        tree.preOrderTraverse(tree.root);
       // tree.midOrderTraverse(tree.root);
       // tree.postOrderTraverse(tree.root);


        tree.preOrderTraverseStack(tree.root);

    }





}
