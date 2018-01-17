package tree;

import java.util.NoSuchElementException;

/**
 * Created by gavin on 2018/1/16.
 */
public class SearchBinarayTree {


    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }


    /****
     * 删除一个节点
     * @param node
     * @return
     */
    public void deleteNote(TreeNode node){

        if (null==node) throw new NoSuchElementException();

        TreeNode parent=node.parent;

        //1.没有孩子节点

        if (null==node.leftChild&& null==node.rightChild){

            if (parent==null){
                root=null;
            } else {

                if (parent.leftChild==node){

                    parent.leftChild=null;
                }else if (parent.rightChild==node){
                    parent.rightChild=null;
                }
            }

            node.parent=null;
            //只有左孩子
        }else if (null!=node.leftChild && null==node.rightChild){

            if (parent==null){

                node.parent=null;
                root=node.leftChild;
                node.leftChild.parent=null;
            }else {

                if (parent.leftChild==node){
                    parent.leftChild=node.leftChild;
                }else {
                    parent.rightChild=node.leftChild;

                }
                node.leftChild.parent=parent;

                node.parent=null;
            }
            //只有右孩子
        }else if (null!=node.rightChild&& null==node.leftChild){

            if (parent==null){

                node.parent=null;
                root=node.rightChild;
                node.rightChild.parent=null;
            }else {

                if (parent.leftChild==node){

                    parent.leftChild=node.rightChild;

                }else {

                    parent.rightChild=node.rightChild;
                }

                node.rightChild.parent=parent;

                node.parent=null;
            }

            //所要删除的节点有两个孩子
        }else {

            //1、删除节点的右子树的左子树是否为null,
            //则把要删除节点的左子树设为删除点的右子树的左子树
            if (node.rightChild.leftChild==null){


                node.rightChild.leftChild=node.leftChild;

                node.leftChild.parent=node.rightChild;

                if (parent==null){

                    root=node.rightChild;
                }

                if (parent.leftChild==node){

                    parent.leftChild=node.rightChild;
                }else {

                    parent.rightChild=node.rightChild;
                }

                node.rightChild.parent=parent;

                node.parent=null;

            }else {


                // 最左子树
                TreeNode leftNode = getMinLeftTreeNode(node.rightChild);
                // 001
                leftNode.leftChild = node.leftChild;
                node.leftChild.parent=leftNode;


                //002
                TreeNode leftNodeP = leftNode.parent;
                leftNodeP.leftChild = leftNode.rightChild;
                leftNode.rightChild.parent=leftNodeP;

                //003
                leftNode.rightChild = node.rightChild;

                node.rightChild.parent=leftNode;



                if (parent==null){

                    root=leftNode;
                }else {

                    if (parent.leftChild == node) {
                        parent.leftChild = leftNode;
                    } else {
                        parent.rightChild = leftNode;
                    }
                }


            }


        }

    }

    private TreeNode getMinLeftTreeNode(TreeNode node) {
        TreeNode curRoot = null;
        if (node == null) {
            return null;
        } else {
            curRoot = node;
            while(curRoot.leftChild != null) {
                curRoot = curRoot.leftChild;
            }
        }
        return curRoot;
    }


    /***
     * 二叉树查找
     * @param data
     * @return
     */
    public TreeNode searchNode(int data){

        if (root==null) return null;

        TreeNode node=root;


        while (node!=null){
            if (node.data==data){
                return  node;
            }else if (node.data<data){

                node=node.rightChild;
            }else {

                node=node.leftChild;
            }
        }

        return null;

    }







    /***
     * 添加元素
     * @param data
     * @return
     */
    public TreeNode put(int data){

        if (root==null){

            TreeNode node=new TreeNode(data);

            root=node;

            return  node;
        }


        TreeNode parent=null;

        TreeNode node=root;


        while (node!=null){

            parent=node;

            if (data<node.data){

                node=node.leftChild;
            }else if (data>node.data){
                node=node.rightChild;
            }else {

                return node;
            }
        }


        TreeNode newNode=new TreeNode(data);

        if (data<parent.data){

            parent.leftChild=newNode;
        }else {
            parent.rightChild=newNode;
        }

        newNode.parent=parent;



        return newNode;
    }

    /****
     * 中序遍历
     * @param root
     */
    public void  midOrderTraverse(TreeNode root){

        if (root==null) return;

        midOrderTraverse(root.leftChild);
        System.out.print(" " + root.data +"   ");

        midOrderTraverse(root.rightChild);


    }



    public class TreeNode{

        int data;

        TreeNode leftChild;

        TreeNode rightChild;

        TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int  data) {
            this.data = data;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }
    }


}
