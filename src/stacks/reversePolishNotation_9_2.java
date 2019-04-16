package stacks;

import linkedList.ListNode;

public class reversePolishNotation_9_2 {

  // 23+ => 5
  //-5,3,+ => -2

  // given string, in RPN give expression result
  /*
  "1729", "3,4,+,2,X,1,+", "1,1,+,-2,x","-641,6,/,28,/".
   */

  // traverse string, push number into stack
  // if come across a non number (unary operator)
    // evaluate by either popping 2 numbers (for very first expr)
    // or popping 1 number  (for all expr after first)

  public int RPN(String eqnRPN){
      myStack stack = new myStack();
      int res = 0;
      // traverse string and populate stack
      String split[] = eqnRPN.split(",");
      for(String word : split){
        if (isInteger(word)){
          stack.push(Integer.parseInt(word));
        } else{
            ListNode<Integer> nodeTwo = stack.pop();
            ListNode<Integer> nodeOne= stack.pop();
            res = compute(nodeOne.data, nodeTwo.data, word);
            stack.push(res);
        }
      }
    return stack.top.data;
  }

  //https://stackoverflow.com/questions/237159/whats-the-best-way-to-check-if-a-string-represents-an-integer-in-java
  public static boolean isInteger(String str) {
    if (str == null) {
      return false;
    }
    int length = str.length();
    if (length == 0) {
      return false;
    }
    int i = 0;
    if (str.charAt(0) == '-') {
      if (length == 1) {
        return false;
      }
      i = 1;
    }
    for (; i < length; i++) {
      char c = str.charAt(i);
      if (c < '0' || c > '9') {
        return false;
      }
    }
    return true;
  }

  // +, -, *, /
  private int compute(int numOne, int numTwo, String operator){
    if (operator.equals("+")) return numOne+numTwo;
    else if (operator.equals("-")) return numOne-numTwo;
    else if (operator.equals("X")) return numOne*numTwo;
    else return numOne/numTwo;
  }


}
