package strings;

import java.util.ArrayList;
import java.util.List;

public class lookAndSay_7_8 {
  // {1, 11, 21, 1211, 111221 ....
  // one one
  // => 11
  // two ones
  // => 21
  // one two one one
  // => 1211
  // one one, one two and then two ones
  // => 111221

  // find num occurences of current number
  // print occurences(num) and then the number

  public String nthSequence(int n){
    List<String> sequence = new ArrayList<>();
    sequence.add("1");
    int currentNumber = -1;
    int occurencesOfNumber = 0;
    int currIdx;
    String currString;
    // grab previous string
    for(int i = 0; i < n; i++){
      currString = sequence.get(i);
      StringBuilder sb = new StringBuilder();
      currIdx = 0;
      // for each number in previous string grab num of occurences
      for(int j = 0; j < currString.length(); j = currIdx) {
        currentNumber = currString.charAt(j) - '0';
        while(currString.charAt(currIdx) - '0' == currentNumber) {
          occurencesOfNumber++;
          currIdx++;
          if(currIdx > currString.length() - 1) break;
        }
        sb.append(occurencesOfNumber);
        sb.append(currentNumber);
        occurencesOfNumber = 0;
      }
      sequence.add(sb.toString());
    }
    for(String res : sequence) System.out.print(res + " ");

    return sequence.get(n-1);
  }
}
