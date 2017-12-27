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


    /****
     *
     * @param index 插入的下标
     * @param e
     */
    public void add(int index, E e) {

        rangeCheck(index);//检查越界
         //检查是否需要扩容数组，如果需要则扩容。
        // size+1,即为需要的最低容量
        ensureCapacity(size + 1);
        for (int i = index; i < size; i++) {
            //元素右移，腾出新位置index
            elementData[i + 1] = elementData[i];
        }
         //将新元素放到下下标为index的位置。
        elementData[index] = e;
        //元素个数加1
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

        rangeCheck(index);//检查下标是否越界
         //保留所要删除的数据
        Object remove = elementData[index];
        fastRemove(index);

        return (E) remove;
    }
    /****
     * 删除元素
     * @param index
     */
    private void fastRemove(int index) {
        //从被删除的元素位置开,其后的元素都依次往前移动
        for (int i = index; i < size; i++) {
            elementData[i] = elementData[i + 1];
        }
        //设置数组元素对象为空(最后一个)
        elementData[size-1]=null;
        size--;
    }

    /***
     * 删除元素
     * @param e
     * @return
     */
    public boolean remove(E e) {

        if (e == null) {//如何元素中有空值

            for (int index = 0; index < size; index++) {

                if (elementData[index] == null) {

                    fastRemove(index);
                    return true;
                }
            }

        } else {

            //循环 找出数据相同的选项的下标index,然后删除
            for (int index = 0; index < size; index++) {
                if (elementData[index] == e) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
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
     * @param newCapacity  size+1
     */
    public void ensureCapacity(int newCapacity) {
        /***
         * 元素个数大于数组的长度
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
     * @param minCapacity 需要扩容的数组最小大小。
     *                    为size+1
     */
    private void graw(int minCapacity) {

        int oldCapacity = elementData.length;//当前数组的长度

        //新数组的长度  为原来数组的1.5倍
        int newCapacity = minCapacity + (oldCapacity >> 1);

        if (newCapacity > oldCapacity) {
            //把原数组赋值给临时数组
            Object[] old = elementData;
            //创建一个新数组，长度为newCapacity
            elementData = new Object[newCapacity];
            //通过一个循化，将原数组的元素复制到新数组里面。
            for (int i = 0; i < old.length; i++) {
                elementData[i] = old[i];
            }
            System.out.println("扩容后的大小 = [" + elementData.length + "]");
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
