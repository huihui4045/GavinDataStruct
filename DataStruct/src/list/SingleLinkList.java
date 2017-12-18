package list;

/**
 * Created by gavin on 2017/12/15.
 * <p>
 * 单链表
 */
public class SingleLinkList<E> {

    private Node<E> head;

    private Node<E> last;


    private int size;


    public SingleLinkList() {


    }


    /****
     * 尾部添加
     * @param element
     */
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (head == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public void add(E element) {

        addLast(element);
    }

    public void add(int index, E element) {


        checkPositionIndex(index);

        if (index == 0)
            addFirst(element);
        else if (index == size) {
            addLast(element);
        } else {

            System.out.println("add   index = [" + index + "]");

            Node<E> preNode = searchElementByIndex(index - 1);

            Node<E> newNode = new Node<E>(element, null);


            newNode.next = preNode.next;

            preNode.next = newNode;

            size++;

        }
    }

    public E remove(E e) {

        Node current = head;
        Node previous = head; //记住上一个节点

        while (current.item != e) {

            if (current.next == null) {

                return null;
            }

            previous = current;

            current = current.next;
        }

        if (current == head) {

            head = head.next;
        }

        if (current == last) {

            last = previous;
        }

        previous.next = current.next;

        size--;


        return (E) current;
    }

    /****
     * 删除当前元素
     * @param index
     * @return
     */
    public E remove(int index) {

        checkPositionIndex(index);

        Node current = head;
        Node previous = head;

        int i = 0;

        while (i != index) {

            i++;

            previous = current;

            current = current.next;
        }

        if (current == head) {

            head = head.next;
        }

        if (current == last) {

            last = previous;
        }

        previous.next = current.next;

        size--;


        return (E) current;
    }

    public E set(int index, E e) {

        Node<E> node = searchElementByIndex(index);

        E old = node.item;

        node.item = e;

        return old;

    }


    public void clear() {

        for (Node<E> x = head; x != null; ) {

            Node<E> next = x.next;

            x.item = null;
            x.next = null;

            x = next;
        }

        head = last = null;
        size = 0;
    }


    public int size() {

        return size;
    }

    /****
     * 通过下标找到节点
     * @param index
     * @return
     */
    private Node<E> searchElementByIndex(int index) {
        checkPositionIndex(index);
        Node<E> temp = head;
        int i = 0;

        while (temp != null) {

            if (i == index) {
                return temp;
            }
            i++;
            temp = temp.next;
        }
        return null;
    }


    /****
     * 头部添加
     * @param element
     */
    public void addFirst(E element) {

        Node<E> newNode = new Node<>(element, null);

        if (head == null) {
            head = last = newNode;
        } else {
            /***
             * 方案一
             */
            //head=new Node<E>(element,this.head);

            Node<E> temp = head;

            newNode.next = temp;
            head = newNode;
        }
        size++;
    }


    public void disPlayAllNode() {

        Node item = head;

        while (item != null) {


            System.out.println("[head:" + head.item + "] data:{" + item.item + "}last:[" + last.item + "]");

            item = item.next;
        }

    }

    private static class Node<E> {

        public Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }

        E item;

        Node next;


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
