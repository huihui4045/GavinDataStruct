package list;

/**
 * Created by gavin on 2017/12/28.
 * <p>
 * 循环单链表
 */
public class CircleHeadILinkedList<E> implements ILinkedList<E> {

    //头节点  不带数据的头结点
    private Node<E> head;
    //尾指针
    private Node<E> tail;

    int size;


    /****
     * a.当循环链表为空链表时，head指向头结点，head.next=head。
     b.尾部指向rear代表最后一个结点，则有rear.next=head。
     */
    public CircleHeadILinkedList() {

        this.head = new Node<E>(null);
        head.next = head;
        tail = head;

    }

    @Override
    public boolean add(E data) {

        if (data == null) return false;


        Node<E> q=new Node<>(data,this.tail.next);
        this.tail.next=q;
        //更新尾部指向
        this.tail=q;

        size++;


        return true;
    }

    @Override
    public boolean isEmpty() {
        //head是否指向头结点
        return head.next == head;
    }

    @Override
    public int length() {

        Node<E> p = head.next;

        int length = 0;

        while (p != head) {

            p = p.next;
            length++;
        }


        return length;
    }

    @Override
    public E get(int index) {

        checkPositionIndex(index);


        E data=null;

        Node<E> node =getNodeByIndex(index);

        if (node!=null){

            data=node.data;
        }


        return data;
    }

    private Node<E> getNodeByIndex(int index){

        Node<E> node = head.next;

        int i=0;

        while (node!=null&&i<index){

            node=node.next;

            i++;

        }


        return node;
    }



    @Override
    public E set(int index, E data) {

        E old;

        //找到节点
        Node<E> node =getNodeByIndex(index);

        old=node.data;

        node.data=data;


        return old;
    }

    @Override
    public boolean add(int index, E data) {

        checkPositionIndex(index);


        Node<E> p=head;
        int i=0;
        // //寻找插入点的位置的前一个结点
        while (p.next!=p &&i<index){

            p=p.next;

            i++;
        }
        //将新节点插到后面
       p.next=new Node<E>(data,p.next);

        //如果p是尾指针，更改尾指针指向
        if (p==tail){
            tail=p;
        }


        size++;

        //while ()


        return true;
    }



    @Override
    public E remove(int index) {

        checkPositionIndex(index);

        Node<E> p=this.head.next;

        int j=0;

        while (p!=head&&j<index){
            j++;
            p=p.next;
        }

        System.out.println("deleter = [" + p.data + "]");


        return null;
    }

    @Override
    public boolean remove(E data) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(E data) {
        return false;
    }

    @Override
    public void disPlay() {

        Node<E> p = head.next;

        System.out.println("链表数据个数："+length());


        while (p != head) {


            System.out.println("data:" + p.data);

            p = p.next;
        }
    }


    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
}
