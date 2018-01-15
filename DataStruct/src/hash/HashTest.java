package hash;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * Created by gavin on 2018/1/12.
 */
public class HashTest {

    public static void main(String[] args) {


        HashMap<Integer,String> aliHashMap=new HashMap<>();
        //AliHashMap<Integer,String> aliHashMap=new AliHashMap<>();


        for (int i=0;i<10;i++){

            aliHashMap.put(i,String.valueOf(i));

        }

        aliHashMap.remove(5);


        for (int i=0;i<10;i++){

            System.out.println(String.format("%d:%s",i,aliHashMap.get(i)));
        }





        //testWeakHash();

      //  System.out.println("map:"+weakHashMap);

    }

    private static void testWeakHash() {
        WeakHashMap<Object,Object> weakHashMap=new WeakHashMap<>(10000);

        for (int i=0;i<1000;i++){

            weakHashMap.put(i,"huihui"+i);
        }

        WeakReference<String> weakReference=new WeakReference<String>("a");


        System.gc();


        //System.runFinalization();


        System.out.println(""+weakReference.get());

        Set<Map.Entry<Object, Object>> entries = weakHashMap.entrySet();

        for (Map.Entry<Object, Object> entry : entries) {

            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
