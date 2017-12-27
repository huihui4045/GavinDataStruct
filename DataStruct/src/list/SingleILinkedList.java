package list;

/**
 * Created by molu_ on 2017/12/26.
 *
 * 单链表
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

        checkPositionIndex(index);
        if (index==0){
            addFirst(data);
        }else {
            //先找到前一个节点
            Node<E> front=searchNodeByIndex(index-1);

/*
            Node<E> newNode=new Node<E>(data,null);
            //更新p的后继指向
            newNode.next=front.next;
            //更新front的后继指向
            front.next=newNode;*/

            //上面三句话可以合并成为一句话
            //这句话上也适用于尾部节点添加
            front.next=new Node<>(data,front.next);


            size++;

        }



        return true;
    }

    /***
     * 在链表尾部添加节点
     * @param data
     */
    public void addLast(E data){

        if (head!=null){

            Node<E> front=head;

            //循环找到尾结点
            while (front.next!=null){

                front=front.next;
            }
            //front的next指针指向新结点，新结点的next指针设置为null
            front.next=new Node<E>(data,null);


        }else {

            head=new Node<>(data,null);
        }

        size++;
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

        size++;

    }

    @Override
    public boolean add(E data) {
        addLast(data);
        return true;
    }

    @Override
    public E remove(int index) {

        checkPositionIndex(index);

        E old=null;

        if (index==0){

            old=head.data;

            head=head.next;
        }else {
             //查找需要删除结点的前一个结点
            Node<E> front=searchNodeByIndex(index-1);


            if (front.next!=null){

                old=front.next.data;

                front.next=front.next.next;
            }

        }


        size--;


        return old;
    }

    @Override
    public boolean remove(E data) {

        Node node=head;

        int index=0;

        while (node!=null){

            if (node.data==data){

              remove(index);

              return true;
            }

            node=node.next;

            index++;
        }


        return false;
    }

    @Override
    public void clear() {
        //清空链表是一件非常简单的事，只需让head=null即可；代码如下：

        for (Node<E> x = head; x != null; ) {

            Node<E> next = x.next;

            x.data = null;
            x.next = null;

            x = next;
        }

        head  = null;
        size = 0;



    }

    @Override
    public boolean contains(E data) {


        Node node=head;

        while (node!=null){

            if (node.data==data){

                return true;
            }

            node=node.next;
        }


        return false;
    }

    @Override
    public void disPlay() {


        if (head==null){
            System.out.println("当前数组为空");
            return;
        }


        Node item=head;

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
