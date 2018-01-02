package stack;

import java.util.EmptyStackException;

/**
 * Created by gavin on 2018/1/2.
 */
public class SeqStack<T> implements IStack<T> {


    /**
     * 栈顶指针,-1代表空栈
     */
    private int top=-1;

    /**
     * 容量大小默认为10
     */
    private int capacity=10;

    /**
     * 存放元素的数组
     */
    private Object[] elementData;

    private int size;

    public SeqStack(int capacity){
        elementData = (T[]) new Object[capacity];
    }

    public SeqStack(){
        elementData= (T[]) new Object[this.capacity];
    }

    public  int size(){
        return size;
    }


    @Override
    public boolean isEmpty() {
        return this.top==-1;
    }


    /****
     * 元素入栈
     * @param data
     */
    @Override
    public void push(T data) {
         //判断是否需要扩容
        ensureCapacity(size+1);

        elementData[++top]=data;

        size++;

    }

    /****
     * 返回栈顶元素,未出栈
     * @return
     */
    @Override
    public T peek() {

        if (isEmpty())
            throw new EmptyStackException();
        return (T) elementData[top];
    }

    /****
     * 元素出栈
     * @return
     */
    @Override
    public T pop() {

        if (isEmpty()){
            throw new EmptyStackException();
        }
        size--;

        return (T) elementData[top--];
    }

    @Override
    public void display() {


    }

    /****
     * 确定数组的大小
     * @param newCapacity  size+1
     */
    private void ensureCapacity(int newCapacity) {
         //元素个数大于数组的长度
        if (newCapacity > elementData.length) {
            //需要扩容
            graw(newCapacity);
        }
    }
    private void graw(int newCapacity) {
        int oldCapacity = elementData.length;//当前数组的长度
        //新数组的长度  为原来数组的1.5倍
        int newlength = oldCapacity + (oldCapacity >> 1);
        if (newlength > oldCapacity) {
            Object[] old = elementData;
            elementData = new Object[newlength];
            for (int i = 0; i < old.length; i++) {
                elementData[i] = old[i];
            }
            System.out.println("扩容后的大小 = [" + elementData.length + "]");
            old = null;
        }

    }
}
