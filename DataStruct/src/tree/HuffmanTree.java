package tree;

import java.util.*;

/**
 * Created by gavin on 2018/1/18.
 */
public class HuffmanTree<E> {


    public static void main(String[] args) {

        List<TreeNode<String>>  nodes=new ArrayList<>();

        nodes.add(new TreeNode<String>("0-59",20));
        nodes.add(new TreeNode<String>("60-70",40));
        nodes.add(new TreeNode<String>("70-79",60));
        TreeNode<String> e = new TreeNode<>("80-89", 30);
        nodes.add(e);
        nodes.add(new TreeNode<String>("90-100",10));

        TreeNode<String> huffmanTree = HuffmanTree.createHuffmanTree(nodes);

        HuffmanTree.disPlayTree(huffmanTree);


        HuffmanTree.getHuffmanCode(e);

    }



    public static void  getHuffmanCode(TreeNode node){

        Stack stack=new Stack();

        TreeNode tNode=node;

        while (tNode!=null && tNode.parent!=null){

            if (tNode.parent.left==tNode){

                stack.push("0");
            }else if (tNode.parent.right==tNode){
                stack.push("1");
            }


            tNode=tNode.parent;
        }

        while (!stack.isEmpty()){

            System.out.println(" "+stack.pop());
        }
    }



    public static void disPlayTree(TreeNode root){

        Queue<TreeNode>  queue=new LinkedList<>();

        queue.add(root);

        //层次遍历

        while (!queue.isEmpty()){

            TreeNode node=queue.poll();

            if (node.data!=null){

                System.out.println("node [data=" + node.data + " weight="+node.weight+"]");
            }


            if (node.getLeft()!=null){

                queue.add(node.getLeft());
            }

            if (node.getRight()!=null){

                queue.add(node.getRight());
            }
        }
    }


    /****
     * 构造haffman树
     * @param nodes
     * @param <E>
     * @return
     */
    public  static <E>TreeNode<E> createHuffmanTree(List<TreeNode<E>> nodes){

        while (nodes.size()>1){

            Collections.sort(nodes);//使用sort方法对nodes进行排序,CompareTo方法实现的是降序排列


            TreeNode<E>  leftNode=nodes.get(nodes.size()-1);
            TreeNode<E>  rightNode=nodes.get(nodes.size()-2);

            TreeNode<E> parent=new TreeNode<>(null,leftNode.weight+rightNode.weight,leftNode,rightNode);



            nodes.remove(leftNode);

            nodes.remove(rightNode);

            nodes.add(parent);


        }

            //最后只剩下一个节点
        return nodes.get(0);
    }








    /****
     * HuffmanTree的节点
     * @param <E>
     */
     static class  TreeNode<E> implements Comparable<TreeNode<E>>{


        private E data;

        private int weight;

        private TreeNode<E>  left;

        private TreeNode<E>  right;

        private TreeNode<E> parent;

        public TreeNode<E> getParent() {
            return parent;
        }

        public void setParent(TreeNode<E> parent) {
            this.parent = parent;
        }

        public TreeNode(E data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        public TreeNode(E data, int weight, TreeNode<E> left, TreeNode<E> right) {
            this.data = data;
            this.weight = weight;
            this.left = left;
            this.right = right;
            this.left.setParent(this);
            this.right.setParent(this);

        }

        public TreeNode<E> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<E> left) {
            this.left = left;
        }

        public TreeNode<E> getRight() {
            return right;
        }

        public void setRight(TreeNode<E> right) {
            this.right = right;
        }


      /*  @Override
        public int compare(TreeNode<E> o1, TreeNode<E> o2) {

            if (o1.weight>o2.weight)

                return 1;

            if (o2.weight>o1.weight){

                return -1;
            }

            return 0;
        }*/

        @Override
        public int compareTo(TreeNode<E> o) {

            if (o.weight>this.weight)

                return 1;

            if (this.weight>o.weight){

                return -1;
            }


            return 0;
        }
    }
}
