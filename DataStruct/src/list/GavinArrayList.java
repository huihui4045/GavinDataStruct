package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by molu_ on 2017/12/14.
 */
public  class GavinArrayList<E>{


    /***
     * 默认大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    private final Object[] EMPTY_ELEMENTDATA = {};

    private final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    private Object[] elementData;


    private int size;

    public GavinArrayList() {

        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public GavinArrayList(int size) {

        if (size > 0) {

            this.elementData = new Object[size];
        } else {

            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    public void add(E e) {

        ensureCapacity(size + 1);


        elementData[size] = e;

        size++;

    }

    /****
     * 修改
     * @param index
     * @param e
     * @return
     */
    public E set(int index, E e) {

        rangeCheck(index);

        Object oldValue = elementData[index];

        elementData[index] = e;


        return (E) oldValue;

    }


    public void add(int index, E e) {

        rangeCheck(index);

        ensureCapacity(size + 1);


        for (int i = index; i < size; i++) {

            elementData[i + 1] = elementData[i];
        }

        elementData[index] = e;

        size++;

    }

    /****
     * 检查下标越界
     * @param index
     */
    private void rangeCheck(int index) {
        if (index < 0 || index > size) {

            String format = outOfBoundsMsg(index);


            throw new IndexOutOfBoundsException(format);
        }
    }


    /****
     * 根据下标删除
     * @param index
     * @return
     */
    public E remove(int index) {


        rangeCheck(index);

        Object remove = elementData[index];

        fastRemove(index);
        return (E) remove;
    }

    /***
     * 删除元素
     * @param e
     * @return
     */
    public boolean remove(E e) {


        if (e == null) {


            for (int index = 0; index < size; index++) {

                if (elementData[index] == null) {


                    fastRemove(index);

                    return true;

                }
            }


        } else {

            for (int index = 0; index < size; index++) {

                if (elementData[index] == e) {

                    fastRemove(index);

                    return true;
                }
            }

        }


        return false;
    }

    /****
     * 删除元素
     * @param index
     */
    private void fastRemove(int index) {
        for (int i = index; i < size; i++) {

            elementData[i] = elementData[i + 1];
        }

        size--;
    }


    private String outOfBoundsMsg(int index) {
        return String.format("Index=%d,size=%d", index, size);
    }

    public E get(int index) {

        if (index > size)

            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));


        return (E) elementData[index];
    }


    public int size() {
        return size;
    }


    /****
     * 确定数组的大小
     * @param newCapacity  数组元素的个数
     */
    public void ensureCapacity(int newCapacity) {


        /***
         * 新数组大于原来的数字大小
         */
        if (newCapacity > elementData.length) {

            /***
             * 需要扩容
             */
            graw(newCapacity);
        }


    }

    /****
     * 扩容数组
     * @param minCapacity
     */
    private void graw(int minCapacity) {


        int oldCapacity = elementData.length;

        int newCapacity = oldCapacity + (oldCapacity >> 1);

        if (newCapacity > oldCapacity) {

            Object[] old = elementData;

            elementData = new Object[newCapacity];

            for (int i = 0; i < old.length; i++) {

                elementData[i] = old[i];
            }


            System.out.println("扩容后的大小 = [" + elementData.length + "]");

            old = null;

        }


    }



    public Iterator<E> iterator() {
        return new GavinIterator();
    }


    private class GavinIterator<E> implements Iterator<E>{


        @Override
        public boolean hasNext() {
            if (currentIndex<size)
                return true;


            return false;
        }

        @Override
        public E next() {
            if (!hasNext()){

                throw  new NoSuchElementException("");
            }


            return (E) elementData[currentIndex++];
        }
    }



    private int currentIndex=0;

}
