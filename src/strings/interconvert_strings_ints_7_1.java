package strings;

public class interconvert_strings_ints_7_1 {


  public int stringToInt(String stringNum){
    int number = 0;

    for(int i = stringNum.charAt(0) == '-' ? 1 : 0; i < stringNum.length(); i++){
      final int digit = stringNum.charAt(i) - '0';
      number = number * 10 + digit;

    }

    return number;
  }

  public String intToString(int num){
    StringBuilder sbNum = new StringBuilder();
    // % 10

    while(num != 0){
      int remainder = num % 10;
      sbNum.append(remainder);
      num /= 10;
    }

    sbNum.reverse();

    return sbNum.toString();

  }

}
