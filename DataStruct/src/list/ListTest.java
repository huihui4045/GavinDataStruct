package list;

import java.util.Iterator;

/**
 * Created by gavin on 2017/12/15.
 */
public class ListTest {

    public static void main(String[] args) {

        //testArrayList();




        SingleLinkList<String> linkList=new SingleLinkList<>();

       // linkList.add("A");
       // linkList.add("B");
      //  linkList.add("C");



       //linkList.addLast("D");

        linkList.add("D");

       linkList.addFirst("B");
       linkList.addFirst("A");

       linkList.add("C");

       linkList.add(0,"0");

       linkList.add(linkList.size(),"1");

       linkList.add(1,"a");

       linkList.add(linkList.size()-1,"e");

        linkList.disPlayAllNode();




        /*for (int i = 0; i < data.size(); i++) {

            System.out.println(String.format("%d:%s",i,data.get(i)));
        }*/
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
