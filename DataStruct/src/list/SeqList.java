package list;

/**
 * Created by gavin on 2017/12/26.
 * 顺序表顶级接口
 */
public interface SeqList<T> {


    boolean isEmpty();//判断链表是否为空
    int length();//链表长度
    T get(int index);//获取元素
    T set(int index, T data);//设置某个元素的值
    boolean add(int index, T data);//根据index添加元素
    boolean add(T data);//添加元素
    T remove(int index);//根据index移除元素
    boolean remove(T data);//根据data移除元素
    boolean removeAll(T data);//根据data移除元素
    void clear();//清空链表
    boolean contains(T data);//是否包含data元素
    int indexOf(T data);//根据值查询下标
    int lastIndexOf(T data);//根据data值查询最后一个出现在顺序表中的下标
    String toString();//输出格式

}
