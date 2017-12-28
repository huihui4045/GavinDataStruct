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


    /****
     * a.当循环链表为空链表时，head指向头结点，head.next=head。
     b.尾部指向rear代表最后一个结点，则有rear.next=head。
     */
    public CircleHeadILinkedList() {

        this.head = new Node<E>(null);
        head.next = head;
        tail.next = head;

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
        return null;
    }

    @Override
    public E set(int index, E data) {
        return null;
    }

    @Override
    public boolean add(int index, E data) {
        return false;
    }

    @Override
    public boolean add(E data) {

        if (data==null)  return false;


        tail=new Node<>(data,tail.next);


        return true;
    }

    @Override
    public E remove(int index) {
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

        Node<E> p = head;

        while (p != head) {



            p = p.next;
        }
    }
}
