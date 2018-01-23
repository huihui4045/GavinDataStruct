package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gavin on 2018/1/19.
 * 平衡二叉树
 */
public class AVLBTree<E extends Comparable<E>> {

    Node<E>  root;

    int size = 0;
    /***
     * 平衡因子
     */
    private static final int LH = 1;
    private static final int RH = -1;
    private static final int EH = 0;


    /****
     * 右平衡操作，即结点t的不平衡是因为右子树过深
     * @param node
     */
    private void rightBalance(Node<E> node){

        Node<E> mRNode=node.right;

        switch (mRNode.balance){

            case RH:

                leftRotate(node);

                node.balance=EH;
                mRNode.balance=EH;

                break;

            case LH:

                Node<E> trl = mRNode.left;
                switch (trl.balance) {
                    case RH:
                        node.balance = LH;
                        mRNode.balance = EH;
                        trl.balance = EH;
                        break;
                    case LH:
                        node.balance = EH;
                        mRNode.balance = RH;
                        trl.balance = EH;
                        break;
                    case EH:
                        node.balance = EH;
                        mRNode.balance = EH;
                        trl.balance = EH;
                        break;
                }
                rightRotate(node.right);
                leftRotate(node);

                break;

            case EH:

                break;
        }


    }

    /****
     * 左平衡操作，即结点t的不平衡是因为左子树过深
     * @param t
     */
    public void leftBalance(Node<E> t) {
        Node<E> tl = t.left;
        switch (tl.balance) {
            case LH:
                rightRotate(t);
                tl.balance = EH;
                t.balance = EH;
                break;
            case RH:
                Node<E> tlr = tl.right;
                switch (tlr.balance) {
                    case LH:
                        t.balance = RH;
                        tl.balance = EH;
                        tlr.balance = EH;
                        break;
                    case RH:
                        t.balance = EH;
                        tl.balance = LH;
                        tlr.balance = EH;
                        break;
                    case EH:
                        t.balance = EH;
                        tl.balance = EH;
                        tlr.balance = EH;
                        break;

                    default:
                        break;
                }
                //旋转
                leftRotate(t.left);
                rightRotate(t);
                break;

            default:
                break;
        }
    }



    /***
     * 右旋
     * @param y
     */
    private void  rightRotate(Node<E> y ){

        if (y!=null){

            Node<E> x=y.left;

            //1
            y.left=x.right;

            if (x.right!=null){

                x.right.parent=y;
            }

            //2

            x.parent=y.parent;

            if (y.parent==null){

                root=x;
            }else {

                if (y.parent.left==y){
                    y.parent.left=x;
                }else if (y.parent.right==y){
                    y.parent.right=x;
                }
            }

            x.right=y;
            y.parent=x;

        }

    }


    /****
     * 平衡树左旋
     * @param x
     */
    private void leftRotate(Node<E> x){

        if (x!=null){


            Node<E> y= x.right;

            //1
            x.right=y.left;

            if (y.left!=null){
                y.left.parent=x;
            }

            //2
            y.parent=x.parent;
            if (x.parent==null){

                root=y;
            }else {

                if (x.parent.left==x){
                    x.parent.left=y;
                }else if (x.parent.right==x){
                    x.parent.right=y;
                }

            }

            //3
            y.left=x;
            x.parent=y;

        }


    }


    public boolean insertElement(E element){

        Node<E> t=root;

        if (null==t){

            root=new Node<>(element,null);

            size=1;
            root.balance=0;

            return true;
        }else {

            int cmp=0;

            Node<E> parent;

            Comparable<? super E> e=(Comparable<? super E>)element;

            do {

                parent=t;

                cmp=e.compareTo(t.element);

                if (cmp < 0) {
					t= t.left;
				} else if (cmp > 0) {
					t= t.right;
				} else {
					return false;
				}

            }while (t!=null);


            Node<E> child=new Node<E>(element,parent);

            if (cmp<0){

                parent.left=child;
            }else {
                parent.right=child;
            }

            while (parent!=null){

                cmp=e.compareTo(parent.element);

                if (cmp>0){
                    parent.balance--;
                }else {
                    parent.balance++;
                }

                if (parent.balance==0){

                    break;
                }

                if (Math.abs(parent.balance)==2){

                    fixAfterInsertion(parent);

                    break;
                }else {

                    parent=parent.parent;
                }

            }

            size++;

            return true;

        }




    }

    private void fixAfterInsertion(Node<E> parent) {

        if (parent.balance==2){

            leftBalance(parent);
        }

        if (parent.balance==-1){

            rightBalance(parent);
        }

    }

    public static void main(String[] args) {


        Integer [] a={5,2,8,0,1,-2};

        AVLBTree<Integer> mTree=new AVLBTree<>();

        for (int i = 0; i < a.length; i++) {

            mTree.insertElement(a[i]);
        }

        disPlayTree(mTree.root);

        System.out.println("root:"+mTree.root.element);


    }


    /****
     * 层析遍历
     * @param root
     */
    public  static void disPlayTree(Node root){

        Queue<Node> queue=new LinkedList<>();

        queue.add(root);

        //层次遍历

        while (!queue.isEmpty()){

           Node node=queue.poll();

            if (node.element!=null){

                System.out.println("node [data=" + node.element + " weight="+node.element+"]");
            }


            if (node.getLeft()!=null){

                queue.add(node.getLeft());
            }

            if (node.getRight()!=null){

                queue.add(node.getRight());
            }
        }
    }


    public static class Node<E extends Comparable<E>>{

        E element;

        Node left;

        Node right;

        /***
         * 平衡因子
         */
        int balance=0;

        Node parent;

        public Node(E element, Node parent) {
            this.element = element;
            this.parent = parent;
        }

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
