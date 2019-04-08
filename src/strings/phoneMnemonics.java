package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class phoneMnemonics {

  // add one letter to each string
  // grab each string
  // for each string add one letter to end of each
  // 2
  // a  b c
  // 2 2
  // aa ab ac ba bb bc ca cb cc
  public void computeMnemonics(Character number, List<String> possibleSequences, Map<Integer, List<Character>> phoneDial){

    if(possibleSequences.size() == 0){
      phoneDial.get(number - '0').stream()
              .forEach( (e) -> {
                possibleSequences.add(e.toString());
              });
    } else{
      IntStream.range(0, possibleSequences.size())
              .forEach(i -> {
                String currentString = possibleSequences.get(i);
                System.out.println("current String = " + currentString);
                phoneDial.get(number - '0').stream()
                        .forEach( (d) -> {
                          System.out.println("d = " + d);
                          System.out.println("index = " + i);
                          StringBuilder sb = new StringBuilder(currentString);
                          sb.append(d);
                          possibleSequences.add(sb.toString());
                        });
              });

    }
  }

  public List<String> driver(String number){
    List<String> possibleSequences = new ArrayList<>();
    Map<Integer, List<Character>> phoneDial = createMap();
    for(Character letter : number.toCharArray()){
      computeMnemonics(letter, possibleSequences, phoneDial);
    }

    System.out.println("printing possible strings");

    for(String combinations : possibleSequences) System.out.println(combinations);
    return possibleSequences;
  }


  private Map<Integer, List<Character>> createMap(){

    Map<Integer, List<Character>> phonePad = new HashMap<>();

    char currentCharacter = 'A';

    for(int i = 2; i <= 9; i++){
      List<Character> dialPad;
      if(i == 7 || i == 9){
        dialPad = List.of(currentCharacter++, currentCharacter++, currentCharacter++,currentCharacter++);
      } else {
        dialPad = List.of(currentCharacter++, currentCharacter++, currentCharacter++);
      }

      phonePad.put(i, dialPad);
    }

    for (Integer keys : phonePad.keySet())
    {
      System.out.println(keys + ":"+ phonePad.get(keys));
    }

    return phonePad;
  }


  public static final String[] MAPPING = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

  public List<String> phoneMnemonic(String number){
    List<String> res = new ArrayList<>();
    char[] partial = new char[number.length()];
    recursiveConstruction(number, 0, partial, res);
    return res;
  }

  private void recursiveConstruction(String number, int digit, char[] partialMnemonic, List<String> mnemonics){

    // one sequence done
    if (digit == number.length()){
      mnemonics.add(new String(partialMnemonic));
    } else {
        // try all possibilities for this digit
      for(int i = 0; i < MAPPING[number.charAt(digit) - '0'].length(); i++){
        char c = MAPPING[number.charAt(digit) - '0'].charAt(i);
        partialMnemonic[digit] = c;
        recursiveConstruction(number, digit + 1, partialMnemonic, mnemonics);
      }
    }
  }




}
