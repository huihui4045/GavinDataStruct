package list;

/**
 * Created by gavin on 2017/12/26.
 */
public class ArraySeqList<T> implements SeqList<T> {




    private final Object[] EMPTY_ELEMENTDATA = {};

    private final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    /***
     * 默认大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    /****
     * 数组存储
     */
    private Object[] elementData;

    /***
     * 数据的个数
     */
    private int size;


    /****
     * 默认为空数组
     */
    public ArraySeqList() {

        elementData=EMPTY_ELEMENTDATA;
    }

    /****
     * 初始化数组的大小
     * @param size
     */
    public ArraySeqList(int size) {

        if (size>0)
            elementData=new Object[size];
        else
            elementData=EMPTY_ELEMENTDATA;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public T get(int index) {

        if (index > size||index<0)
            //抛出下表越界的异常  size为数组中元素的大小，并不是数组的长度
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        return (T) elementData[index];

    }

    /****
     * 替换元素
     * @param index
     * @param data
     * @return
     */
    @Override
    public T set(int index, T data) {
        rangeCheck(index);//首先检查下标是否越界
        T old= (T) elementData[index];//获取原来的值
        elementData[index]=data;//赋予新值
        return old;//返回旧值
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
        int newLength = oldCapacity + (oldCapacity >> 1);

        if (newLength > oldCapacity) {

            Object[] old = elementData;

            elementData = new Object[newLength];

            for (int i = 0; i < old.length; i++) {
                elementData[i] = old[i];
            }
            System.out.println("扩容后的大小 = [" + elementData.length + "]");
            old = null;
        }
    }

    @Override
    public boolean add(int index, T data) {


        rangeCheck(index);

        ensureCapacity(size+1);

        for (int i = index; i < size; i++) {
            //元素右移，腾出新位置index
            elementData[i + 1] = elementData[i];
        }
        //将新元素放到下下标为index的位置。
        elementData[index] = data;
        //元素个数加1
        size++;

        return true;
    }

    @Override
    public boolean add(T data) {
        return add(size,data);
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T data) {
        return false;
    }

    @Override
    public boolean removeAll(T data) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public int indexOf(T data) {
        return 0;
    }

    @Override
    public int lastIndexOf(T data) {
        return 0;
    }


    private String outOfBoundsMsg(int index) {
        return String.format("Index=%d,size=%d", index, size);
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
}
