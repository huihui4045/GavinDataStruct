package list;

/**
 * Created by molu_ on 2017/12/14.
 */
public class GavinArrayList<E> {


    /***
     * 默认大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    private  final Object[] EMPTY_ELEMENTDATA = {};

    private  final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    private Object[] elementData;


    private int size;

    public GavinArrayList() {

        this.elementData=  new Object[DEFAULT_CAPACITY];
    }

    public GavinArrayList(int size) {

        if (size>0){

            this.elementData=new Object[size];
        }else {

            this.elementData=EMPTY_ELEMENTDATA;
        }
    }

    public void  add(E e){



        elementData[size]=e;

        size++;

    }



}
