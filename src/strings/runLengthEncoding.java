package strings;

public class runLengthEncoding {


  // aabb
  // 2a2b
  public String encoding(String toEncode){
    char prevChar, currChar;
    int count = 1;
    StringBuilder sb = new StringBuilder();

    prevChar = toEncode.charAt(0);
    currChar = ' ';
    for(int i = 1; i < toEncode.length(); i++){
      currChar = toEncode.charAt(i);

      if(currChar == prevChar){
        count++;
      } else{
        sb.append(count);
        sb.append(prevChar);
        prevChar = currChar;
        count = 1;
      }
    }

    sb.append(count);
    sb.append(currChar);

    return sb.toString();
  }


  public String decoding(String toDecode) {

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < toDecode.length() - 1; i+=2) {
      int count = toDecode.charAt(i) - '0';
      char curr = toDecode.charAt(i + 1);
      while (count > 0) {
        sb.append(curr);
        count--;
      }
    }

    return sb.toString();
  }
}
