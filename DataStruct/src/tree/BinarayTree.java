package tree;

import java.util.Stack;

/**
 * Created by gavin on 2018/1/15.
 *
 * 二叉树的遍历
 */
public class BinarayTree {

    public Node<String> root;


    public BinarayTree() {

        root=new Node<>("A",null,null);

        creatTree();
    }

    private void creatTree(){

        Node<String>  B=new Node<>("B",null,null);
        Node<String>  C=new Node<>("C",null,null);
        Node<String>  D=new Node<>("D",null,null);
        Node<String>  E=new Node<>("E",null,null);
        Node<String>  F=new Node<>("F",null,null);
        Node<String>  G=new Node<>("G",null,null);


        root.leftChild=B;
        root.rightChild=C;

        B.leftChild=D;
        B.rightChild=E;

        C.leftChild=F;
        C.rightChild=G;
    }

    /****
     * 二叉树 前序遍历
     * @param root
     */
    public void preOrderTraverse(Node  root){

        if (root==null)  return;

        System.out.println("pre = [" + root.data + "]");

        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
    }

    /***
     * 通过栈实现二叉树的遍历
     * @param root
     */
    public void preOrderTraverseStack(Node root){

        if (root==null)  return;

        Stack<Node>  stack=new Stack<>();

        stack.push(root);

        while (!stack.empty()){

            Node<String> cur = stack.pop();

            System.out.println("pre  stack = [" + cur.data + "]");

            if (cur.rightChild!=null)
            stack.push(cur.rightChild);

            if (cur.leftChild!=null)
                stack.push(cur.leftChild);
        }

    }

    /****
     * 中序遍历
     * @param root
     */
    public void  midOrderTraverse(Node  root){

        if (root==null) return;

        midOrderTraverse(root.leftChild);
        System.out.println("mid = [" + root.data + "]");

        midOrderTraverse(root.rightChild);


    }

    /****
     * 后序遍历
     * @param root
     */
    public void  postOrderTraverse(Node  root){

        if (root==null) return;

        postOrderTraverse(root.leftChild);
        postOrderTraverse(root.rightChild);
        System.out.println("post = [" + root.data + "]");


    }



    public static class Node<T>{

        T data;

        Node<T> leftChild;
        Node<T> rightChild;

        public Node(T data, Node<T> leftChild, Node<T> rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
}
