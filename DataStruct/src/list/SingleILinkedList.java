package list;

/**
 * Created by molu_ on 2017/12/26.
 */
public class SingleILinkedList<E> implements ILinkedList<E> {



    private Node<E> head;

    private int size;

    public SingleILinkedList() {

    }

    /***
     * 判断链表是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return head==null;
    }

    /****
     * 获取链表的长度
     * @return
     */
    @Override
    public int length() {

        int length=0;

        Node<E> p=head;

        while (p!=null){

            length++;
            p=p.next;
        }


        return length;
    }

    /****
     * 通过下标获取节点
     * @param index
     * @return
     */
    @Override
    public E get(int index) {

        //检查是否越界
        checkPositionIndex(index);

        Node<E> p=head;

        int i=0;

        //循环找到找到对应索引的结点
        while (p!=null){
           if (i==index){
               return p.data;
           }
           i++;
           p=p.next;
        }

        return null;
    }

    @Override
    public E set(int index, E data) {

        checkPositionIndex(index);

        Node<E> oldNode=searchNodeByIndex(index);
        //将老值赋值给data
        E old=oldNode.data;

        oldNode.data=data;

        return old;
    }

    /****
     * 通过下标找到节点
     * @param index
     * @return
     */
    private Node<E> searchNodeByIndex(int index) {

        //checkPositionIndex(index);

        Node<E> p = head;
        int i = 0;

        while (p != null) {
            if (i == index) {
                return p;
            }
            i++;
            p = p.next;
        }
        return null;
    }



    @Override
    public boolean add(int index, E data) {





        return true;
    }

    /****
     * 添加到链表头部
     * @param data
     */
    public void addFirst(E data) {

        if (head!=null){
            /*//创建新节点
            Node<E> newNode=new Node<E>(data,null);
            //newNode的后继指针 指向头结点
            newNode.next=head;
            //更新head
            head=newNode;*/
            head=new Node<>(data,head);
        }else {
            head=new Node<>(data,null);
        }

    }

    @Override
    public boolean add(E data) {


        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean removeAll(E data) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(E data) {
        return false;
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
