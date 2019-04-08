package strings;

public class Palindrome_ex_7_5 {

  public boolean isPalindrome(String s1){
    s1 = s1.toLowerCase();

    int leftPtr = 0;
    int rightPtr = s1.length() - 1;
    char leftChar;
    char rightChar;

    while(leftPtr < rightPtr){
      while(!Character.isLetter(s1.charAt(leftPtr))){
        leftPtr++;
      }

      while(!Character.isLetter(s1.charAt(rightPtr))){
        rightPtr--;
      }

      leftChar = s1.charAt(leftPtr++);
      rightChar = s1.charAt(rightPtr--);

      if(leftChar != rightChar) return false;
    }

    return true;

  }
}
