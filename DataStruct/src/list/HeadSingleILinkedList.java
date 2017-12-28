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
         //检测越界情况
        checkPositionIndex(index);

        //无需区分位置操作,中间/头部/尾部插入
        Node p=head;
        int i=0;
        //查找到插入位置即index的前一个结点
        while (p.next!=null && i<index){
            p=p.next;
            i++;
        }
        ////将新插入的结点的后继指针指向pre.next
        Node<E> node=new Node<E>(data,p.next);
        //更改指针指向,指向当前插入的节点
        p.next=node;
        //如果p是尾部指针。
        if (p==last){
            last=node;
        }

        size++;
        return true;
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
        checkPositionIndex(index);
        E old=null;
        //无需区分头删除或中间删除或尾部删除的情况
        Node<E> pre=head;
        int i=0;
         //查找需要删除位置的前一个结点
        while (pre.next!=null&&i<index){
            pre=pre.next;
            i++;
        }
        Node<E> node=pre.next;
        if (node!=null){
            old=node.data;
         //如果恰好是尾部结点,则更新rear的指向
            if (node==last){
                last=pre;
            }
            //更改指针指向
            pre.next=node.next;
        }
        size--;
        return old;
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
