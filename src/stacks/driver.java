package stacks;

public class driver {

  public static void main(String[] args){

    myStack orderStack = createOrderedStack();
    maxAPI_9_1 ex_9_1 = new maxAPI_9_1();
    System.out.println("max in stack: " + ex_9_1.returnMax(orderStack));
    System.out.println();

    reversePolishNotation_9_2 ex_9_2 = new reversePolishNotation_9_2();
    System.out.println("RPN of \"3,4,+,2,X,1,+\" => " + ex_9_2.RPN("3,4,+,2,X,1,+"));
    System.out.println("RPN of \"3\" => " + ex_9_2.RPN("3"));
    System.out.println("RPN OF \"1,1,+,-2,X\" => "+  ex_9_2.RPN("1,1,+,-2,X"));

    System.out.println();
    balancedParatheses_9_3 ex_9_3 = new balancedParatheses_9_3();
    System.out.println("[()[]{()()}] is well formed : " + ex_9_3.isWellFormed("[()[]{()()}]"));
    System.out.println("([]){()} is well formed : " + ex_9_3.isWellFormed("([]){()}"));
    System.out.println("}{}{ is well formed: " + ex_9_3.isWellFormed("}{}{"));

    



  }




  public static myStack createOrderedStack(){
    myStack stack = new myStack(0);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    return stack;
  }
}
