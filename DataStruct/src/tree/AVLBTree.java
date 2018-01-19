package tree;

/**
 * Created by gavin on 2018/1/19.
 * 平衡二叉树
 */
public class AVLBTree<E> {









    public class Node<E extends Comparable<E>>{

        E element;

        Node left;

        Node right;

        int balance=0;

        Node parent;


        public Node(E element, Node left, Node right, Node parent) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }



}
