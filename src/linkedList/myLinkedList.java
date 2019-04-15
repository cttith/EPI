package linkedList;

public class myLinkedList<T> {

  private ListNode<T> head;
  private ListNode<T> tail;
  private int size;

  public myLinkedList(){
    head = null;
    tail = null;
    size = 0;
  }

  public void add(T data) {
    ListNode<T> newNode = new ListNode<>(data);
    if (size == 0){
      head = newNode;
      tail = newNode.next;
    }else {
      tail.next = newNode;
      tail = newNode;
    }
    size++;
  }

  public void add(ListNode<T> node){
    // if list empty
    if (size == 0){
      head = node;
      tail = head.next;
      size++;
      // if list contains nodes already
    }else {
      tail.next = node;
      tail = node;
      size++;
    }

  }

  public void printList() {
    ListNode<T> root = head;
    while (root != null) {
      System.out.print(root.data + " ");
      root = root.next;
    }
  }

}
