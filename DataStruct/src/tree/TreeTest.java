package tree;

import java.util.*;

/**
 * Created by gavin on 2018/1/16.
 */
public class TreeTest {

    public static void main(String[] args) {

        //binarayTreeTest();

        //searchBinarayTreeTest();

        TreeMap<Integer,String>  treeMap=new TreeMap<>();

        TreeSet<String>  treeSet=new TreeSet<>();

        HashMap<Integer,String>  hashMap=new HashMap<>();

        HashSet<String>  hashSet=new HashSet<>();


        hashMap.put(1,"A");
        hashMap.put(3,"B");
        hashMap.put(2,"C");
        hashMap.put(8,"D");
        hashMap.put(6,"E");



        treeMap.put(1,"A");
        treeMap.put(3,"B");
        treeMap.put(2,"C");
        treeMap.put(8,"D");
        treeMap.put(6,"E");




        hashSet.add("语文");
        hashSet.add("英语");
        hashSet.add("物理");
        hashSet.add("化学");
        hashSet.add("社会");
        hashSet.add("计算机");




        treeSet.add("语文");
        treeSet.add("英语");
        treeSet.add("物理");
        treeSet.add("化学");
        treeSet.add("社会");
        treeSet.add("计算机");



        Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();

        System.out.print("hashMap =");

        while (iterator.hasNext()){

            System.out.print("  "+iterator.next().getValue());


        }

        System.out.println();


        Iterator<Map.Entry<Integer, String>> treeMapIterator = treeMap.entrySet().iterator();

        System.out.print("treeMap =");

        while (treeMapIterator.hasNext()){

            System.out.print("  "+treeMapIterator.next().getValue());
        }


        System.out.println();

        Iterator<String> iteratorHashSet = hashSet.iterator();

        System.out.print("hashSet =");

        while (iteratorHashSet.hasNext()){

            System.out.print("  "+iteratorHashSet.next());
        }

        System.out.println();

        Iterator<String> treesetIterator = treeSet.iterator();

        System.out.print("treeSet =");

        while (treesetIterator.hasNext()){

            System.out.print("  "+treesetIterator.next());
        }

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
