package linkedList;


public class removeNode_8_6 {

  // DO IN O(1)
  // (can't traverse the list)

  // cannot be tail of list
  // copy data from next node to node to delete ...essentially removing
  public void deleteNode(ListNode<Integer> nodeToDelete){
    nodeToDelete.data = nodeToDelete.next.data;
    nodeToDelete.next = nodeToDelete.next.next;
  }
}
