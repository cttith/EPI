package strings;

import java.util.HashMap;
import java.util.Map;

public class spreadSheetEncoding_7_3 {

  public int decodeColumn(String columnID){

    Map<Character, Integer> columnMap = new HashMap<>();
    int capitalA = (int) 'A' ;    // 65
    for(int i = 0; i < 26; i++){
      columnMap.put((char) (capitalA + i), i+65);
    }

    int lastCharValue = columnMap.get(columnID.charAt(columnID.length()-1));
    return columnID.length() > 1 ? (int) Math.pow(26, columnID.length()) + (lastCharValue-64) : lastCharValue-64;
  }
}
