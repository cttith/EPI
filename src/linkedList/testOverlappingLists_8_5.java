package linkedList;

import strings.Palindrome_ex_7_5;

public class testOverlappingLists_8_5 {

  // case analysis
  // both lists have no cycles
    // check for overlap
  // one list has cycle
    // no overlap
  // both lists have cycles
    // check if overlap happens before entering cycle
        // run check for overlap
    // check if overlap happens after entering cycle
      // return any node in cycle

  public ListNode<Integer> testOverlapCycles(ListNode<Integer> listOne, ListNode<Integer> listTwo){

    testCycle_8_3 ex_8_3 = new testCycle_8_3();
    findIntersectingNode_8_4 ex_8_4 = new findIntersectingNode_8_4();
    ListNode<Integer> cycleOne = ex_8_3.findCycle(listOne);
    ListNode<Integer> cycleTwo = ex_8_3.findCycle(listTwo);

    // both lists hae no cycle, see if they have intersection
    if (cycleOne == null && cycleTwo == null)
      return ex_8_4.findIntersection(listOne, listTwo);

    // one list has cycle, therefore no overlap
    if ((cycleOne != null && cycleTwo == null) || (cycleOne == null && cycleTwo != null))
      return null;

    // both lists have cycle
      // same cycle (overlap exists)
        // overlap node occurs before lists enter cycle
        // overlap node occurs in cycle
     // different cycle (no overlap)
    ListNode<Integer> tmp2 = cycleTwo;
    do{
      tmp2 = tmp2.next;
    }while (tmp2 != cycleOne || tmp2 != cycleTwo);

    // disjoint cycles
    if (tmp2 != cycleOne) return null;

    // same cycle
      // overlap occurs before lists entire cycle (find distance separated by and return node they == to when traversing
    // can't use findIntersecting fxn b/c assumes no cycle
    // find distances from roots to where cycles starts
    int listOneLength = distance(listOne, cycleOne), listTwoLength = distance(listTwo, cycleTwo);
    int diff = Math.abs(listOneLength - listTwoLength);
    if (listOneLength > listTwoLength){
      listOne = advanceListByK(listOne, diff);
    } else{
      listTwo = advanceListByK(listTwo, diff);
    }

    // traverse and see if they ovelrap before cycle or @ cycle entrance
    while (listOne != listTwo && listOne != cycleOne && listTwo != cycleTwo){
      listOne = listOne.next;
      listTwo = listTwo.next;
    }

    // if they're equal, they overlap before cycle; return listOne or listTwo
    // if they;re not equal, they overlap inside cycle; return cycleone or cycletwo
    return listOne == listTwo ? listOne : cycleOne;

  }

  private int distance(ListNode<Integer> travelNode, ListNode<Integer> destNode){
    int dis = 0;
    while (travelNode != destNode){
      travelNode = travelNode.next;
      dis++;
    }
    return dis;
  }

  private ListNode<Integer> advanceListByK(ListNode<Integer> node, int dist){
    while (dist != 0) {
      node = node.next;
      dist--;
    }
  return node;
  }

}
