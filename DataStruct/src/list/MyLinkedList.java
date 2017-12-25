package list;

/**
 * Created by molu_ on 2017/12/25.
 */
public class MyLinkedList<T> {


    private Node<T> head=null;

    public void add(T item){

        Node newNode=new Node(item,null);

        if (null==head){

            head=newNode;
        }else {

            Node<T> temp=head;

            while (temp.next!=null){

                temp=temp.next;
            }

            temp.next=newNode;
        }

    }


    public void display(){

        Node<T> node=head;

        int i=0;

        while (node!=null){

            System.out.println(i+":"+node.item.toString());

            i++;

            node=node.next;
        }
    }



    public void reverse(){

        Node curr=head;

        Node reve=null;

        while (curr!=null){

            Node temp=curr;

            curr=curr.next;

            temp.next=reve;

            reve=temp;
        }

        head=reve;
    }



    private static class Node<E> {

        public Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }

        E item;

        Node next;

    }


}
