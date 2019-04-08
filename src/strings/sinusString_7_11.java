package strings;

public class sinusString_7_11 {

  // return snakestring

  //      E                 _               L
  //  H       L       O         W       R       D
  //              L                 O               !

  //snake string = E_L + HLOWRD + LO!
  // even indices are in the 0th row
  // odd indices are in 1st or -1st row
    //  we alternate every odd character starting with 1st row THEN -1st row

  public String returnSnakeString(String word){
    StringBuilder sb = new StringBuilder();

    // How to do with one string... need to be clever with index OR just do three separate for loops

    // 1st row
    for(int i = 1; i < word.length(); i+=4)
      sb.append(word.charAt(i));

    // 0th row
    for(int i = 0; i < word.length(); i+=2)
      sb.append(word.charAt(i));

    // -1st row
    for(int i = 3; i < word.length(); i+=4)
      sb.append(word.charAt(i));

    return sb.toString();
  }
}
