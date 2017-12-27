package list;

import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * Created by gavin on 2017/12/15.
 */
public class ListTest {

    public static void main(String[] args) {

        //testArrayList();


        testLinkList();

       /* MyLinkedList<String>  linkedList=new MyLinkedList<>();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add("F");

        linkedList.display();


        linkedList.reverse();

        linkedList.display();*/




        /*for (int i = 0; i < data.size(); i++) {

            System.out.println(String.format("%d:%s",i,data.get(i)));
        }*/
    }

    private static void testLinkList() {
        SingleLinkList<String> linkList=new SingleLinkList<>();

        // linkList.add("A");
        // linkList.add("B");
        //  linkList.add("C");


        //linkList.addLast("D");

        linkList.add("D");

        linkList.addFirst("B");
        linkList.addFirst("A");
        linkList.addFirst("C");

        linkList.disPlayAllNode();

        System.out.println("================================");

        String result = linkList.set(0, "xiong");

        System.out.println("result:"+result);

        //linkList.remove(0);

        //linkList.remove("D");

        //linkList.remove(0);

        linkList.disPlayAllNode();
    }


    private static void testArrayList() {
        GavinArrayList<String> data=new GavinArrayList<>();

        data.add(0,"a");
        data.add(1,"b");
        data.add("c");
        data.add("d");
        data.add("e");
        data.add("f");
        data.add("e");
        data.add("f");
        data.add("g");
        data.add("h");
        data.add("i");
        data.add("j");
        data.add("k");
        data.add("l");

        data.remove(0);

        data.remove("l");

        data.set(2,"替换的");


        Iterator<String> iterator = data.iterator();

        while (iterator.hasNext()){

            System.out.println("item = [" + iterator.next() + "]");
        }
    }
}
