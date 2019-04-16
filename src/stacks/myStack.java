package stacks;

import linkedList.ListNode;

public class myStack{

  private int size;
  ListNode<Integer> top;

  myStack(){
    size = 0;
    top = null;
  }

  myStack(int value){
    size = 1;
    top = new ListNode<Integer>(value);
    top.max = value;
    top.next = null;
  }

  public void push(int value){
    if (size == 0){
      size = 1;
      top = new ListNode<Integer>(value);
      top.max = value;
      top.next = null;
    } else {
      ListNode<Integer> newNode = new ListNode<>(value);
      if (value > top.data) {
        newNode.max = value;
      } else newNode.max = top.max;

      newNode.next = top;
      top = newNode;
      size++;
    }
  }

  public ListNode<Integer> pop(){
    if (size == 0) return null;
    ListNode<Integer> oldTop = top;
    top = top.next;
    size--;
    return oldTop;
  }

  public int peek(){
    if (!isEmpty())
      return top.data;
    return -1;
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public int max(){
    return top.max;
  }

}
