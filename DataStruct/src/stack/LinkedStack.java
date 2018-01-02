package stack;

import list.Node;

import java.util.EmptyStackException;

/**
 * Created by gavin on 2018/1/2.
 */
public class LinkedStack<T> implements IStack<T> {


    private Node<T> top;

    private int size;

    public LinkedStack() {
        top=new Node<T>(null);
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /****
     * 入栈操作
     * @param data
     */
    @Override
    public void push(T data) {

            top=new Node<T>(data,top);

        size++;
    }

    /***
     * 返回栈顶元素
     * @return
     */
    @Override
    public T peek() {

        if (size<=0)
            throw new EmptyStackException();
        return top.data;
    }

    /***
     * 出栈
     * @return
     */
    @Override
    public T pop() {

        if (size<=0)
            throw new EmptyStackException();

        Node<T> old=top;

        top=top.next;

        size--;

        return old.data;
    }

    @Override
    public void display() {

    }
}
