package linkedList;

public class ListNode<T> {
    public T data;
    public ListNode<T> next;
    public int max;

    public ListNode(){

    }

    public ListNode(T newData){
      data = newData;
      next = null;
    }

}
