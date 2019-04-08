package strings;

import java.util.HashMap;
import java.util.Map;

public class roman2Decimal_7_9 {
  /*
  I can immediately precede V and X.
  X can immediately precede L and C.
  C can immediately precede D and M.
  L => 50
  C => 100
  D => 500
  M => 1000
  cannot have IXC
  */



  // I = 1
  // II = 2
  // III = 3
  // IV = 4
  // V = 5
  // V1 = 6
  // IX = 9
  // X = 10
  // XIV = 14
  // XIX = 19
  // grab curr symbol
  // grab next symbol
  // if next <= curr
  //  add curr symbol to sum
  // if next > curr
  //    add next-curr to sum

  //  IV => 4
  //  IX => 9
  //  XL => 40
  //  XC => 90
  //  CD => 400
  //  CM => 900

  private static final Map<Character, Integer> MAPPING= new HashMap<>(){{
    put('I', 1);
    put('V', 5);
    put('X', 10);
    put('L', 50);
    put('C', 100);
    put('D', 500);
    put('M', 1000);
  }};

  public int convert2Decimal(String romanRepresentation){

    int decimalRepresentation = 0;
    boolean addLastSymbol = false;
    System.out.println("symbol : " + romanRepresentation);

    // IX => 9
    for(int i = 0; i < romanRepresentation.length() - 1; i++){
      char currSymbol = romanRepresentation.charAt(i);
      char nextSymbol = romanRepresentation.charAt(i+1);
      int nextInt = MAPPING.get(nextSymbol);
      int currInt = MAPPING.get(currSymbol);
      if(nextInt <= currInt){
        decimalRepresentation += currInt;
        addLastSymbol = true;
      }
      else {
        decimalRepresentation += (nextInt - currInt);
        i+=2;
        addLastSymbol = false;
      }
    }

    if(addLastSymbol)
      decimalRepresentation += MAPPING.get(romanRepresentation.charAt(romanRepresentation.length()-1));

    System.out.println("final result = " + decimalRepresentation);


    return decimalRepresentation;

  }


}
