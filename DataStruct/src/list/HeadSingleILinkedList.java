package list;

/**
 * Created by gavin on 2017/12/27.
 * 带头结点并含有尾指针的链表
 */
public class HeadSingleILinkedList<E> implements ILinkedList<E> {

    public Node<E> head;

    public Node<E> last;

    private int size=0;

    public HeadSingleILinkedList() {

        head=last=new Node<E>(null);
    }

    @Override
    public boolean isEmpty() {
        return head.next==null;
    }

    @Override
    public int length() {
        return size;
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

    /****
     * 从头结点插入
     * @return
     */
    public boolean addFirst(E data){

        Node<E> newNode=new Node<>(data,head.next);
        head.next=newNode;
        //newNode为空的话，说明newNode即使第一个节点，也是最后一个节点
        //将尾指针指向newNode
        if (newNode.next==null){
            last=newNode;
        }

        size++;
        return true;
    }

    /****
     * 删除第一个结点
     * @return
     */
    public E removeFirst(){
        Node<E> p=head.next;

        if (p==null)
            throw new IndexOutOfBoundsException("当前链表为空");
        //判断删除p后面还有没有节点
        if (p.next==null)
            last=head;
        //头结点指向后一个节点
        head.next=p.next;

        size--;

        return p.data;
    }



    @Override
    public boolean add(E data) {

        Node<E> newNode = new Node<>(data, null);

        if (head.next==null)//判断是不是第一次插入
            head.next=newNode;
        else {
            last.next=newNode;
        }
        last= newNode;

        size++;

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

        if (head.next==null){
            System.out.println("当前数组为空");
            return;
        }
        //从head.next开始遍历
        Node item=head.next;

        while (item!=null){
            System.out.print(item.data+"  ");
            item=item.next;
        }

        System.out.println("");
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
