package tree;

/**
 * Created by gavin on 2018/1/15.
 *
 * 二叉树的遍历
 */
public class BinarayTree {


    /****
     * 二叉树 前序遍历
     * @param root
     */
    public void preOrderTraverse(Node  root){

        if (root==null)  return;

        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
    }

    public static class Node<T>{

        T data;

        Node<T> leftChild;
        Node<T> rightChild;
    }
}
