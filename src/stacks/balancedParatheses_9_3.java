package stacks;

import java.util.Deque;
import java.util.LinkedList;

public class balancedParatheses_9_3 {

  private boolean isAmatch(char closing, char opening){
    if (closing == (')'))
      return opening == ('(');
    else if (closing == (']'))
      return opening == ('[');
    else if (closing == ('}'))
      return opening == ('{');

    return false;
  }


  private boolean isOpening(char paran){
    return paran == '{' || paran == '(' || paran == '[';
  }

  public boolean isWellFormed(String parantheses){

    Deque<Character> charStack = new LinkedList<>();

    for(char paran : parantheses.toCharArray()){
      if (isOpening(paran))
        charStack.push(paran);
      else {
        if (charStack.size() < 1) return false;
        if (!isAmatch(paran, charStack.pop()))
          return false;
      }
    }

    return true;
  }


}
