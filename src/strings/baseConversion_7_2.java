package strings;

public class baseConversion_7_2 {


  public String convertBase(String numAsString, int base1, int base2){
    boolean isNegative = numAsString.startsWith("-");

    int num = 0;

    // b1 to base 2
    for(int i = isNegative ? 1 : 0; i < numAsString.length(); i++){
      num *= base1;

      num += Character.isDigit(numAsString.charAt(i)) ? numAsString.charAt(i) - '0' :
              numAsString.charAt(i) - 'A' + 10;
    }

    return (isNegative ? "-" : "" ) + constructFromBase(num, base2);
  }

  private String constructFromBase(int numAsInt, int base2){
    return (numAsInt == 0) ? "" :
            constructFromBase(numAsInt/base2, base2) + (char)(numAsInt % base2 >= 10 ? 'A' + numAsInt % base2 - 10 :
                    '0' + numAsInt % base2);
  }
}
