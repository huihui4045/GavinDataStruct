package stack;

/**
 * Created by gavin on 2018/1/2.
 */
public class StackTest {

    public static void main(String[] args) {


        testLinkStack();
    }


    private static void testLinkStack(){


        LinkedStack<String>  stack=new LinkedStack<>();

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        while (!stack.isEmpty()&&stack.getSize()>0){

            System.out.println("item:"+stack.pop());
        }


    }

    private static void testSeqStack() {
        SeqStack<String> stack=new SeqStack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        while (!stack.isEmpty()&&stack.size()>=0){

            System.out.println("item = [" + stack.pop() + "]");
        }
    }
}
